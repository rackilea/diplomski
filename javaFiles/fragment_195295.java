String s  = "1a1a2aa3aaa4aaaa15aaaaa6aaaaaa";

Pattern p = Pattern.compile("[a-zA-Z]+");
Matcher m = p.matcher(s);

List<String> matches = new ArrayList<String>();

while (m.find()) {
  matches.add(m.group());
}

System.out.println(matches); // => [a, a, aa, aaa, aaaa, aaaaa, aaaaaa]