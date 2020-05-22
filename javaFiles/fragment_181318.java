public static void passStringBuilder(StringBuilder sb) {
    int yearSlash = sb.lastIndexOf("/");
    sb.delete(yearSlash + 1, sb.length());
    sb,append("2012");
    System.out.println("New date string: " + sb.toString());
}