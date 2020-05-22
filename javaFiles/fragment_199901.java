String text = "letters in a string";
int index = 2;
StringBuilder sb = new StringBuilder(text);
while (index < sb.length()) {
    sb.setCharAt(index - 1, Character.toUpperCase(sb.charAt(index - 1)));
    index *= 2;
    System.out.println(index);
}

System.out.println(sb.toString());