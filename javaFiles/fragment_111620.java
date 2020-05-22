String a = "Example";
char[] b = new char[10];
for (int i = 0; i < b.length; i++) {
    b[i] = a.charAt(i % a.length());
}
for (char x : b) System.out.println(x);