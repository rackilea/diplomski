public static void main( String[] args )
{
    String foo = "";
    System.out.println("String length: " + foo.length());
    String[] parts = foo.split("\t");
    System.out.println("Array Length: " + parts.length);
    System.out.println("Length of that one String in the array: " + parts[0].length());
}