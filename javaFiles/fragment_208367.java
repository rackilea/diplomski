public static String removeDate(String s) {
    final String extension = s.substring(s.lastIndexOf("."));
    final String pattern = "\\d{8}\\" + extension;

    return s.replaceAll(pattern, extension);
}

public static void main(String args[])
{
    System.out.println(removeDate("test20190101.pdf"));
    System.out.println(removeDate("123123test20190101.txt"));
    System.out.println(removeDate("123te11st20190101.csv"));
}