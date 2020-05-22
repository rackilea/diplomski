public static void main(String[] args) {
    String alphabet = "abcdefghijklmnopqrstuvwxyzåäö";
    System.out.println(alphabet);

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < alphabet.length(); i++) {
        char c = alphabet.charAt(i);
        sb.append(i % 2 == 0 ? Character.toUpperCase(c) : c);
    }
    String result = sb.toString();
    System.out.println(result);
}