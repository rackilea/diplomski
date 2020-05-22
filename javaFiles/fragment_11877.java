public static void main(String[] args)
    {
        ArrayList<Integer> lst = Recursive.buildList(5);
        System.out.println(lst);
        lst = reverse(lst);                   ////update lst reference

        System.out.println(lst);
        System.out.println(reversedList);    //// OR print reversedList directly 
    }