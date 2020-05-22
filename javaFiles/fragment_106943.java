String value= "'S1':'99','78','67','60','75';'S2':'66','76','56','70','80';'S3':'89','76','81','70','90';";
char ch =  (char) System.in.read();
String NewValue=  value.replaceAll("'", "");
StringTokenizer str=new StringTokenizer(NewValue, ";");
    while(str.hasMoreTokens()){

          String checkstring=str.nextToken();
          char check=checkstring.charAt(0);

          if(ch==check){
                System.out.println(checkstring.substring(checkstring.indexOf(":")+1));
          }
    }
}