public class Main {
    public static int [] prize = {5,2,3,7,1,5,9,0,2};

    public static void main(String [] args)
    {
        List<Integer> list = Arrays.stream(prize).
                boxed().collect(Collectors.toList());

        System.out.println(list);

        List <Integer> sortedList = list.stream() //error gone on this line
                                           .sorted()
                                           .collect(Collectors.toList());

        System.out.println(sortedList);
    }
}