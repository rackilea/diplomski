public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    ArrayList<String> names = new ArrayList<String>();
    ArrayList<Integer> total = new ArrayList<Integer>();
    int [][] scores = new int [5][6];
    int score = 0;

    for (int i = 0; i < 5; i++) {
        System.out.print("Enter " + "(" + (i+1) + ") friend's name: ");
        names.add(input.nextLine());
    }

    for (int i = 0; i < 5; i++) {
        int tlsc = 0;
        for (int j = 0; j < 6; j++) {
            score = 1 + (int)(Math.random() * ((20 + 1)));
            tlsc+=score;
            scores[i][j] = score;   
        }
        total.add(tlsc);
    }
}