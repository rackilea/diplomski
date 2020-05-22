public static void main(String[] args) {
    String word;
    int range;

    Scanner input = new Scanner(System.in);

    System.out.println("Input characters");
    word = input.nextLine();
    System.out.println("Input range");
    range = Integer.parseInt(input.nextLine());

    //Ascending
    int rows = range/2;
    for(int i=0; i<rows; i++){
        for(int k=0; k<=i; k++){
            System.out.print(word + " ");
        }
        System.out.println();
    }

    //Descending
    for(int i=rows-1; i>0; i--){
        for(int k=0; k<i; k++){
            System.out.print(word + " ");
        }
        System.out.println();
    }
}