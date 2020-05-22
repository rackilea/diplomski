int minLength = Math.min(a.length(), b.length());
for (int i = 0; i < minLength; i++) {
    System.out.print(a.charAt(i));
    System.out.print(b.charAt(b.length() - i - 1));
}
System.out.print(a.substring(minLength));
System.out.print(new StringBuilder(b).reverse().substring(minLength));