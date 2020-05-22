public static void main(String[] args)
  {
    String txt=" 12 170 0.11918";

    String re1="(\\s+)";    // White Space 1
    String re2="(\\d+)";    // Integer Number 1
    String re3="(\\s+)";    // White Space 2
    String re4="(\\d+)";    // Integer Number 2
    String re5="(\\s+)";    // White Space 3
    String re6="([+-]?\\d*\\.\\d+)(?![-+0-9\\.])";  // Float 1

    Pattern p = Pattern.compile(re1+re2+re3+re4+re5+re6,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
    Matcher m = p.matcher(txt);
    if (m.find())
    {
        String ws1=m.group(1);
        String int1=m.group(2);
        String ws2=m.group(3);
        String int2=m.group(4);
        String ws3=m.group(5);
        String float1=m.group(6);
        System.out.print("("+ws1.toString()+")"+"("+int1.toString()+")"+"("+ws2.toString()+")"+"("+int2.toString()+")"+"("+ws3.toString()+")"+"("+float1.toString()+")"+"\n");
    }
  }