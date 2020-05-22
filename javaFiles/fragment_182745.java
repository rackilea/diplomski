import java.util.ArrayList;
import java.util.Arrays;
import org.apache.commons.math3.util.ArithmeticUtils;

class Prob{
    public boolean listsEqual(Integer[] integers, Integer[] rootComp){
        if(integers.length != rootComp.length){
            return false;
        }
        for (int i = 0; i < integers.length; i++){
            if(integers[i] != rootComp[i]){return false;};
        }       
        return true;
    }

    public Integer[] firstComp(int base, int length){
        Integer[] comp = new Integer[length];
        Arrays.fill(comp, 1);
        comp[0] = base - length + 1;
        return comp;        
    }

    public Integer[][] enumerateComps(int base, int length){
        //Provides all compositions of base of size length

        if(length > base){return null;};
        Integer[] rootComp = firstComp(base, length);
        ArrayList<Integer[]> compsArray = new ArrayList<Integer[]>();

        do {
            compsArray.add(rootComp);
            rootComp = makeNextComp(rootComp);
        } while(!listsEqual(compsArray.get(compsArray.size() - 1), rootComp));

        Integer[][] newArray = new Integer[compsArray.size()][length];

        int i = 0;
        for (Integer[] comp : compsArray){
            newArray[i] = comp;
            i++;
        }

        return newArray;
    }

    public double getProb(int k, int n, int m){
        //k = # of bins
        //n = number of objects
        //m = number of empty bins

        //First generate list of length k-m compositions of n

        if((n < (k-m)) || (m >= k)){
            return 0;
        }

        int[] comp = new int[n-1];

        Arrays.fill(comp, 1);

        comp[0] = n - (k-m) + 1;

        //Comp is now the first 
        Integer[][] L = enumerateComps(n, k-m);

        double num = 0;
        double den = Math.pow(k, n);
        double prodSum;
        int remainder;

        for(Integer[] thisComp : L){
            remainder = n;
            prodSum = 1;
            for(Integer thisVal : thisComp){
                prodSum = prodSum * ArithmeticUtils.binomialCoefficient(remainder, thisVal);

                remainder -= thisVal;
            }

            num += prodSum;
        }

        return num * ArithmeticUtils.binomialCoefficient(k, m) / den;
    }

    public Integer[] makeNextComp(Integer[] rootComp){
        Integer[] comp = rootComp.clone();

        int i = comp.length - 1;
        int lastVal = comp[i];
        i--;

        for(; i >=0 ; i--){
            if (comp[i] != 1){
                //Subtract 1 from comp[i]
                comp[i] -= 1;
                i++;
                comp[i] = lastVal + 1;
                i++;
                for(;i < comp.length; i++){
                    comp[i] = 1;
                };
                return comp;                
            }
        }
        return comp;
    }
}


public class numbersTest {
    public static void main(String[] args){
        //System.out.println(ArithmeticUtils.binomialCoefficient(100,50));
        Prob getProbs = new Prob();

        Integer k = 10; //ships
        Integer n = 10; //shots
        Integer m = 4; //unscathed

        double myProb = getProbs.getProb(k,n,m);

        System.out.printf("Probability of %s ships,  %s hits, and %s unscathed: %s",k,n,m,myProb);
    }
}