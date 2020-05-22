public static void main(String[] args) throws Exception {

   URL aURL = new URL("http://www.google.com/stackoverflow/question");
    String[] pathSplit = aURL.getPath().split("/");
    System.out.println("path1 = " + pathSplit[1]);
    System.out.println("path2 = " + pathSplit[2]);
}