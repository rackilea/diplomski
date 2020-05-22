String bienvenue_intro = " Welcome! Java First Semester: 455, java street: City (State): Country: 575757 ";
StringBuilder sb = new StringBuilder(bienvenue_intro);

for (int i = 0; i < bienvenue_intro.length(); i++) {
  char c = bienvenue_intro.charAt(i);
  if (   (c == 'A') || (c == 'a')
      || (c == 'E') || (c == 'e')
      || (c == 'I') || (c == 'i')
      || (c == 'O') || (c == 'o')
      || (c == 'U') || (c == 'u')) {
    sb.setCharAt(i, '*');
  }
}
System.out.println(bienvenue_intro);
//System.out.println(sb.toString());

String[] introduction = sb.toString().split(":");  //<-- Do the split here after replacements.
for (String string : introduction) {
  System.out.println(string);
}