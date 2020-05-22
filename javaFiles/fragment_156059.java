package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> where = new ArrayList<String>();
        where.add("5 Kg");
        where.add("500 gram");
        where.add("1 Kg");

        Collections.sort(where, new MassComparator());

        for(String mass : where) {
            System.out.println(mass);
        }
    }

    public static class MassComparator implements Comparator<String> {

        @Override
        public int compare(String weight1, String weight2) {
            double val1 = Double.parseDouble(weight1.replace("gram", "").replace("Kg", "").trim());
            double val2 = Double.parseDouble(weight2.replace("gram", "").replace("Kg", "").trim());

            if (weight1.contains("gram")) {
                val1 *= .001;
            }

            if (weight2.contains("gram")) {
                val2 *= .001;
            }

            int result = 0;

            if (val1 < val2) {
                result = -1;
            } else if (val1 > val2) {
                result = 1;
            }

            return result;
        }

    }
}