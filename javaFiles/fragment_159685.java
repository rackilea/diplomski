int n = 3;
String s = "abcdefghijkl";

System.out.println(Arrays.toString( s.split("(?<=\\G.{2})(?=.)", n + 1 ) ) );

//prints: [ab, cd, ef, ghijkl], i.e. you have 3 2-char groups and the rest