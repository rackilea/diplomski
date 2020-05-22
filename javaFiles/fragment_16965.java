public static void main(String args[])
{
    Item[] items = new Item[5];
    items[0]= new Item("ABC");
    items[1]= new Item("ABCAA");
    items[2]= new Item("ABCAAC");
    items[3]= new Item("ABCAAA");
    items[4]= new Item("ABBABZ");

    // THIS IS THE IMPORTANT PART!
    Arrays.sort(items, new CompareByNumberOfA());

    System.out.println(items[0].string);
    System.out.println(items[1].string);
    System.out.println(items[2].string);
    System.out.println(items[3].string);
    System.out.println(items[4].string);
}