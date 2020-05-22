Scanner in = new Scanner(System.in);
String s = in.next();

if (s.equals("bad")) {
throw new IOException("Wrong input");
}