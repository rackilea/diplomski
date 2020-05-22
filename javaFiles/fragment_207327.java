public static void main(String[] args)
{
    String mainStr = "mother";
    String otherStr = "other";

    int index = myIndexOf(mainStr, otherStr);
    System.out.println("My Index: " + index);

    // Just for a sanity check
    System.out.println("String Index: " + mainStr.indexOf(otherStr));
}