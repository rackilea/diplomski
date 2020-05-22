String s = "h e l l o, world! ! am gl@d to see    you!";
System.out.println(s);
s = s.replaceAll("(?<=\\b\\p{L})\\s+(?=\\p{L}\\b)", ""); // remove spaces separating single letters
System.out.println(s);
s = s.replaceAll("\\s+(?=\\P{L})", ""); // remove spaces before non-letters
System.out.println(s);
s = s.replaceAll("(\\P{L})\\1+", "$1"); // remove repeated non-letters
System.out.println(s);
s = s.replaceAll("@", "a"); // replace '@' with 'a'
System.out.println(s);