public static void main(String[] args) {

Scanner s = new Scanner(System.in);
int height = s.nextInt();
char star = '*';

 for(int i = 0;i < height; i++) {

    for(int j = 0; j < height - i; j++) {
        System.out.print(" ");
    }

    for(int k = 0; k <= i; k++) {
        System.out.print(star + " ");
    }
    System.out.println();  
}

}