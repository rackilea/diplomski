public class StringArraySorter {
    public static void main(String[] args) {
        String array[][]={  {"5", "22,2", "car payment", "visa", "21/04/2016"},
                {"1", "44,4", "shop", "cash", "16/02/2017"},
                {"2", "33,1", "shop", "cash", "15/01/2020"},
                {"3", "17,3", "gym", "visa", "10/01/2016"},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
        };

        Arrays.sort(array, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                String a1 = o1[1]; // amount field
                String a2 = o2[1]; // amount field
                if (a1 != null && a2 != null) {
                    a1 = a1.replace(',', '.');
                    a2 = a2.replace(',', '.');
                    return Float.compare(Float.parseFloat(a2), Float.parseFloat(a1));
                }
                return 1; // non-null value for amount takes precedence, whatever that may be
            }
        });
        System.out.println(Arrays.deepToString(array));
    }
}