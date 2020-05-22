String s = "monday";
int n = 10;
String chr = "a";

int baseNum = s.length() - s.replace(chr, "").length();
int baseCnt = (n / s.length()) * baseNum;
int index = n % s.length();
String left = s.substring(0, index);
int finalCnt = left.length() - left.replace(chr, "").length();
int totalCnt = baseCnt + finalCnt;

System.out.println("There were " + totalCnt + " letter " + chr + ".");