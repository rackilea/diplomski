String s = "1a1a2aa3aaa4aaaa15aaaaa6aaaaaa";
String[] parts = s.split("[^a-zA-Z]+")

for (String m: parts) {
    System.out.println(m);
}