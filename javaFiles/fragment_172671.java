public static void main(String[] args) {
    String alphabet = "abcdefghijklmnopqrstuvwxyzåäö";
    System.out.println(alphabet);

    char[] chars = alphabet.toCharArray();
    for (int i = 0; i < alphabet.length(); i+=2) {
        chars[i] = Character.toUpperCase(chars[i]);
    }
    String result = new String(chars);
    System.out.println(result);
}