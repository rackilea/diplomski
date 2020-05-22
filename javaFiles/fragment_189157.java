Scanner kybd = new Scanner(System.in);
StringBuilder result = new StringBuilder();
String s = kybd.nextLine();
String[] arr = s.split(" ");
 for ( String ss : arr) {
     if(ss.contains("e")) {
         result.append(ss);
     }
}