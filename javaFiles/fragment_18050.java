URL url = new URL(s);
String path = url.getPath();
if (path.endsWith("asp")) {
    System.out.println("Yes");
} else {
    System.out.println("No");
}