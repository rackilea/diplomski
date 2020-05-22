int minLength = Math.min(a.length(), b.length());
for (int i = 0; i < minLength; i++) {
    System.out.print(a.charAt(i));
    System.out.print(b.charAt(i));
}
System.out.print(a.substring(minLength)); // prints the remaining if 'a' is longer
System.out.print(b.substring(minLength)); // prints the remaining if 'b' is longer