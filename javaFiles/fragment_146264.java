public class InsertionSort {
        public static void main(String[] args) {
            Comparable[] a = new Comparable[]{5,6,12,1,3,15,4,0,9};
            sort(a);
            for (int i = 1 ; i < a.length; i++)
                assert a[i].compareTo(a[i-1]) >= 0;
            System.out.println("sort is correct");
        }

        public static void sort(Comparable[] a) { // Sort a[] into         increasing order.
            int N = a.length;
            for (int i = N - 1; i > 0; i--) { // Insert a[i] among         a[i-1], a[i-2],a[i-3]... ..                               
                for (int j = i; j < N && less(a[j - 1], a[j]); j++)
                    exch(a, j, j - 1);
            }
        }

        private static void exch(Comparable[] a, int i, int j) { 
            Comparable t = a[i];
            a[i] = a[j];
            a[j] = t;
        }

                private static boolean less(Comparable v, Comparable w)                 {                                                   
            return v.compareTo(w) < 0;
        }

    }