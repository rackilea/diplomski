public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        String[][] Students = new String[5][2];
        int i;
        int l = 0;
        for (i = 0; i < 5; i++) {

            System.out.println("Please put in a students name.");
            Students[i][0] = Input.nextLine();
            System.out.println("Please put in a students test score.");
            Students[i][1] = Input.nextLine();
        }
        System.out.println("Score\tName");
        Display(Students);

    }