class Test {

  public static void main(String[] args) {
    String str="123456";
    StringBuffer sb=new StringBuffer(str);
    int x=0;
    for (int i = 0;i < str.length()-1; i++)
      {
        sb.insert(++x, ",");
        x += 1;
      }
      System.out.println(sb);  
    }

}