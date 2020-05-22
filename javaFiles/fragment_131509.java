public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in); // used for scanning user input
    while(true){
        System.out.println("please enter a word : ");
        String mot = scanner.nextLine();  // wait for user to input a word and enter
        System.out.println("mot is : "+mot);
    }
}