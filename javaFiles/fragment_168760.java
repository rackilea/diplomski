public static void main(String[] args){
  SomethingElse se = new SomethingElse();
  Something     sg = se;
  System.out.println(se.aMethod());
  System.out.println(sg.aMethod());
}