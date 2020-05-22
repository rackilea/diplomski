public static void main(String[] args)
{
    String example = "Hello, I'm\" here";
    example = example.replaceAll("'", "\\\\'");
    example = example.replaceAll("\"", "\\\\\"");
    System.out.println(example);
}