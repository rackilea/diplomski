int scale = 2, rpt = 3;
String s = "abc\ndef", ss = "";
for (String t : s.split("\n")) { //Word loop
  for (int j = 0; j < rpt; j++) { //Repeat loop
    for (char c : t.toCharArray()) { //Char loop
      for (int i = 0; i < scale; i++) { //Scale loop
        ss += c;
      }
    }
    ss += "\n";
  }
}
System.out.println(ss); 
/*
aabbcc
aabbcc
aabbcc
ddeeff
ddeeff
ddeeff
*/