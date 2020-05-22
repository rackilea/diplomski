public class Test
{
    public static java.util.List<Integer> list = Arrays.asList(2, 5, 7, 24, 5, 9, 13, 2);

    public static void main(String[] args)
    {

        System.out.println("index of 5 = " + list.lastIndexOf(5));
        System.out.println("index of 100 = " + list.lastIndexOf(100));

        System.out.println(lastIndexOf(5));
        System.out.println(lastIndexOf(100));
    }


    public static int lastIndexOf (int element) {
    int index = 0;
    int found = -1;
    List<Integer> current = list;
    while (index < current.size()) {
       if (current.get(index) == element) {
           found = index;
       }
       index ++;
    }
    return found;
    }
}