import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Snippet {

    static class Country {

        float mNaturalResistance;
    }

    static class PercentageBox {

        Country mCountry = new Country();
    }

    public static void main(final String[] args) {
        List< PercentageBox > mNaturalResistanceBoxes = new ArrayList< Snippet.PercentageBox >();
        for (int i = 0; i < 4; i++) {
            mNaturalResistanceBoxes.add(new PercentageBox());
        }

        mNaturalResistanceBoxes.get(0).mCountry.mNaturalResistance = 3.3f;
        mNaturalResistanceBoxes.get(1).mCountry.mNaturalResistance = 2.2f;
        mNaturalResistanceBoxes.get(2).mCountry.mNaturalResistance = 4.4f;
        mNaturalResistanceBoxes.get(3).mCountry.mNaturalResistance = 1.1f;

        Collections.sort(mNaturalResistanceBoxes, new Comparator< PercentageBox >() {

            @Override
            public int compare(final PercentageBox o1, final PercentageBox o2) {
                return o1.mCountry.mNaturalResistance < o2.mCountry.mNaturalResistance ? -1
                    : o1.mCountry.mNaturalResistance > o2.mCountry.mNaturalResistance ? 1 : 0;
            }
        });

        for (PercentageBox box : mNaturalResistanceBoxes) {
            System.out.println(box.mCountry.mNaturalResistance);
        }
    }
}