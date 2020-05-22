public static void main(String[] args) {
    String[] files = new String[]{"book", "food", "nature"};

    System.out.println("These files are available:");
    for(int i = 0; i<files.length;i++){
        System.out.println((i+1) + ") " + files[i]);
    }
    Scanner scanner = new Scanner(System.in);
    System.out.println("Which file do you want to open?");
    int input = scanner.nextInt();
    System.out.println();
    System.out.println("You have chosen: " + files[input-1]);
}