void subBinary(ArrayList<Integer> list)
{
    int temp = 0, difference = list.get(0);
    for (int i = 1; i <= list.size() - 1; i++)
    {
       temp = list.get(i);
       difference -= temp;
    }

    String foo = Integer.toBinaryString(difference); // convert the difference to a string

    System.out.println("The difference of the numbers in binary is " + foo);
}