int n = 3 // or whatever number;
String repl = "";

if (n > 0) {
   repl = str.replaceAll("((\\S)\\2{" + (n-1) + "})\\2*", "$1");
}