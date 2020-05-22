String word = "Sugar";
int length = word.length();
StringBuilder sb = new StringBuilder(word.length());
for (int number = 0; number < length; number++) {
    sb.append(word.charAt(number));
    System.out.println(sb.toString());
}