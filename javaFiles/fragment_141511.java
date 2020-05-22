String input = "bc";
String sample = "abc123ABC$$";
String result = "";    
for (int i = 0; i < sample.length(); i++) {
     if (input.toUpperCase().contains(String.valueOf(sample.charAt(i)).toUpperCase())
             || (!Character.isLetter(sample.charAt(i)))) {
         result+=String.valueOf(sample.charAt(i));
     }
}
System.out.println(result);