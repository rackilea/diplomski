public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    System.out.println("Testing Scanner, write something: ");
    String testi = scan.nextLine();
    char[] ascii1 = testi.toCharArray();

    for(char ch:ascii1){
        System.out.println((int)ch+"  ");
    }


    System.out.println("Testing Scanner, write something: ");
    String testi2 = scan.nextLine();
    char[] ascii2 = testi2.toCharArray();

    for(char ch:ascii2){
        System.out.println((int)ch+"  ");
    }

  scan.close();
}