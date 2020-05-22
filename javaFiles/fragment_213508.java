public class ListFunctions {
    public static <T1, T2, T3> List<T3> crossProduct(List<T1> list1, List<T2> list2, Function<T1, T2, T3> fn) {
        List<T3> product = new ArrayList<T3>();
        for (int i = 0; i < list1.size(); i++)
          for (int j = 0; j < list2.size(); j++)
            product.add(fn.function(list1.get(i), list2.get(j)));
        return product;
    }
}