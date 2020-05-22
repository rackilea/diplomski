public static void main(String[] args) {
    String mapStr = "qwertyuiopasdfghjklzxcvbnm", phrase = "Hello";
    for (char ch : phrase.toLowerCase().toCharArray()) {
        System.out.print(mapStr.charAt(ch - 'a'));
    }
    System.out.println();
}