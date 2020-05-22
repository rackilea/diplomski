public class SortTest {
    public static void main(String[] args) {
        String[] test = new String[]{
            "a",
            "b",
            "b.a",
            "b.a.a",
            "a.a.a",
            "a.b.a",
            "a.a",
            "a.b",
            "b.a.b",
            "b.b.a"
        };

        Arrays.sort(test, new Comparator<String>() {

        int compareComplexList(List<String> a, List<String> b, List<int[]> positions, int order ) {

          int minimum = a.size() < b.size() ? a.size() - 1 : b.size() - 1;   

          if (a.get(positions.get(minimum)[order]).compareTo(b.get(positions.get(minimum)[order])) != 0)
                return a.get(positions.get(minimum)[order]).compareTo(b.get(positions.get(minimum)[order]));
          else if (order < minimum - 1) return compareComplexList(a,b, positions, ++order);
          else return Double.compare(a.size(),b.size());
        }

        public int compare(String a, String b) {
          List<String> partsA = Arrays.asList(a.split("\\."));
          List<String> partsB = Arrays.asList(b.split("\\."));
          List<int[]>  orders = new ArrayList<int[]>();

          orders.add(new int[] {0});
          orders.add(new int[] {0,1});
          orders.add(new int[] {0,2,1});

          return compareComplexList(partsA, partsB, orders,0);
        }
        });
        System.out.println("Sorted: "+Arrays.toString(test));
    }

}