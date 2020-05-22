public static String removeSpaces(String s) {
    StringTokenizer st = new StringTokenizer(s," ",false);
    String t = "";

    int i=0;  // counter variable

    while(st.hasMoreElements()){

       switch(i)
       {
          case 2:
          case 3:
                 t =  t + " ";
                 break;
          case 5:
                 t =  t + "  ";
                break;
          default:
                 t =  t + ";";
                 break;
       }

       t = t + st.nextElement();
       ++i;
    }

    t =  t + ";";  // put the last semi-colon

    return t;
}