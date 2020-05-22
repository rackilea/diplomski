public static void main(String[] argv)
throws Exception
{
    String s1 = "this\r\nis a test";
    String s2 = s1.replaceAll("[\n\r]", "");
    System.out.println(s2);
}