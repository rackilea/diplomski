public static void main(String eth[]) {
    int a = readInt();
    int b = readInt();
    int answer = (a + b);
    System.out.println(answer);
}
private static int readInt() {
    System.out.println("Write An Integer");
    Scanner input = null;
    while(!(input = new Scanner(System.in)).hasNextInt()){
        System.out.println("Play By The Rules, Write An Integer");
    }
    return input.nextInt();
}