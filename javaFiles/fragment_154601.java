for( i = 0; i < input.length(); i ++){
     if (input.charAt(i) == letter)
     {
     count = count + 1;
     }
  }
String str = (count==1)?"time":"times";
  System.out.println("The letter '" + letter + "' appears "  + count + str + " in the string " + "\"" + input + ".\"");