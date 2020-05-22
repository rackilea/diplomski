char[] chars = displayed;
for (int j = 0; j < displayed.length(); j++) {
    if (input.charAt(0) == secret.charAt(j)) {
        chars[j] = secret.charAt(j);
    }
}
displayed = new String(chars);
System.out.println(displayed);