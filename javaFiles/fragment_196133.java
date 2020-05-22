try {
   int i = Integer.parseInt(yourString);
   System.out.println(i);
} catch(NumberFormatException e) {
   // the string is not a number
}