Scanner in = new Scanner(System.in);
String s = new String();

while(in.hasNextLine()){
     StringBuffer buf = new StringBuffer(in.nextLine());
     s += buf.reverse() + "\n";
}
System.out.println(s);