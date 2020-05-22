public class Combins {

            static String[] a = new String[] { "A", "B", "C" };

            public static void main(final String[] args) {

                final int maxbit = 1 << a.length;

                //for each combination given by a (binary) number 'p'...
                for (int p = 0; p < maxbit; p++) {
                    final List<String> res = new ArrayList<String>();

                    //evaluate if array 'a' element at index 'i' is present in combination (and include it if so)
                    for (int i = 0; i < a.length; i++) {
                        if ((1 << i & p) > 0) {
                            res.add(a[i]);
                        }
                    }
                    System.out.println(Arrays.toString(res.toArray()));
                }
            }
        }