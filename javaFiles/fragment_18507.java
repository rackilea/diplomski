public static void main (String[] args) throws java.lang.Exception
{
    List<String> myList = Arrays.asList("Emma", "Taylor", "Jacob", "Roger", "JP");
    System.out.println("Total letters per word is: ");
    for (int i = 0; i < myList.size(); i++) //for loop incorrect
    {
    System.out.println(myList.get(i)+" = " + myList.get(i).length());
    }
}