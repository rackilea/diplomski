String str = "abcdefg";
StringBuilder sb = new StringBuilder(str.length());
for (char c : str.toCharArray()) {
    sb.append(c);
    System.out.println(sb);
}