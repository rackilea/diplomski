String input = "ab ab.\n";

for(int i = 0; i < input.length() - 1; i++){
   String c = "" + input.charAt(i) + input.charAt(i + 1);
   System.out.println(c);
}