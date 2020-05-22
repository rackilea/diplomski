import gnu.trove.iterator.TIntIntIterator;
import gnu.trove.map.TIntIntMap;
import gnu.trove.map.hash.TIntIntHashMap;
import gnu.trove.procedure.TIntIntProcedure;
import gnu.trove.set.TIntSet;
import gnu.trove.set.hash.TIntHashSet;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math.MathException;
import org.apache.commons.math.stat.inference.OneWayAnova;
import org.apache.commons.math.stat.inference.OneWayAnovaImpl;
import org.apache.commons.math.stat.inference.TestUtils;


public class TestMath {
    private static final double SIGNIFICANCE_LEVEL = 0.001; // 99.9%

    public static void main(String[] args) throws MathException {
        double[][] observations = {
           {150.0, 200.0, 180.0, 230.0, 220.0, 250.0, 230.0, 300.0, 190.0 },
           {200.0, 240.0, 220.0, 250.0, 210.0, 190.0, 240.0, 250.0, 190.0 },
           {100.0, 130.0, 150.0, 180.0, 140.0, 200.0, 110.0, 120.0, 150.0 },
           {200.0, 230.0, 150.0, 230.0, 240.0, 200.0, 210.0, 220.0, 210.0 },
           {200.0, 230.0, 150.0, 180.0, 140.0, 200.0, 110.0, 120.0, 150.0 }
        };

        final List<double[]> classes = new ArrayList<double[]>();
        for (int i=0; i<observations.length; i++) {
            classes.add(observations[i]);
        }

        OneWayAnova anova = new OneWayAnovaImpl();
//      double fStatistic = anova.anovaFValue(classes); // F-value
//      double pValue = anova.anovaPValue(classes);     // P-value

        boolean rejectNullHypothesis = anova.anovaTest(classes, SIGNIFICANCE_LEVEL);
        System.out.println("reject null hipothesis " + (100 - SIGNIFICANCE_LEVEL * 100) + "% = " + rejectNullHypothesis);

        // differences are found, so make t-tests
        if (rejectNullHypothesis) {
            TIntSet aux = new TIntHashSet();
            TIntIntMap fraud = new TIntIntHashMap();

            // i vs j unpaired t-tests - O(n^2)
            for (int i=0; i<observations.length; i++) {
                for (int j=i+1; j<observations.length; j++) {
                    boolean different = TestUtils.tTest(observations[i], observations[j], SIGNIFICANCE_LEVEL);
                    if (different) {
                        if (!aux.add(i)) {
                            if (fraud.increment(i) == false) {
                                fraud.put(i, 1);
                            }
                        }
                        if (!aux.add(j)) {
                            if (fraud.increment(j) == false) {
                                fraud.put(j, 1);
                            }
                        }
                    }           
                }
            }

            // TIntIntMap is sorted by value
            final int max = fraud.get(0);
            // Keep only those with a highest degree
            fraud.retainEntries(new TIntIntProcedure() {
                @Override
                public boolean execute(int a, int b) {
                    return b != max;
                }
            });

            // If more than half of the elements are different
            // then they are not really different (?)
            if (fraud.size() > observations.length / 2) {
                fraud.clear();
            }

            // output
            TIntIntIterator it = fraud.iterator();
            while (it.hasNext()) {
                it.advance();
                System.out.println("Element " + it.key() + " has significant differences");             
            }
        }
    }
}