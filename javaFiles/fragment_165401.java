public static void main(String[] args) {

    Random r = new Random();
    int randomInt = r.nextInt(3);

    String words[] = { "lude", "lose", "stop" };
    String randomWord = words[randomInt];

    System.out.println(randomWord);
}