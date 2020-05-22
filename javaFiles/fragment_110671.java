int t = Integer.parseInt(sc.nextLine());        // nextLine here too to consume return char
while (t > 0) {
  String s = sc.nextLine();
  StringTokenizer st = new StringTokenizer(s);
  a = b = 0;
  if (st.hasMoreTokens()) { a = Integer.parseInt(st.nextToken()); }else{ a=0; }  //line 18
  if (st.hasMoreTokens()) { b = Integer.parseInt(st.nextToken()); }else{ b=0; }  //line 19
  System.out.println("a : " + a + ", b : " + b);
  t--;
}