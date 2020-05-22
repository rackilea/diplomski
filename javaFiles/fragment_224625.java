public static void main(String[] args) {
    System.out.println("Hello World");

    Scanner in = new Scanner(System.in);
    String NandK = in.nextLine();
    String[] pow = NandK.split("\\s+");

    for(int i = 0;i<pow.length;i++){
        String valueOfN = pow[i];
        System.out.println(valueOfN);

    }