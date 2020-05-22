public double convertArchToDecimal(String instr, String delimiter) {
  String[] s = instr.split(delimiter);
  int ret = 0;
  for(int t = 0; t < s.length; t++) {
    char c = s[t].charAt(s[t] - length);
    switch(c) {
       case '\'':  //escape single quote
         String b = s[t].substring(0, s[t].length - 1).split("/");
         try {
           ret += Integer.parse(s[t].trim()) * 12;
         } catch(Exception e) { // Should just need to catch if the parse throws an error
         }
         break;
       case '"':  // may need to escape the double quote
         String b = s[t].substring(0, s[t].length - 1).split("/");
         int f = 0;
         int g = 0;
         try {
            f = Integer.parse(b[0]);
            g = Integer.parse(b[1]);
            ret += f/g;
         } catch(Exception e) {
         }
         break;
       default:
         try {
           ret += Integer.parse(s[t].trim());
         } catch(Exception e) { // Should just need to catch if the parse throws an error
         }
         break;
     }
  }
  return ret;
}