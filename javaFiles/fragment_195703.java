public static void main(String[] args) {
    final File file = new File("/Users/admin/Desktop/studentScores.in");  // reads from file

    try {
        final Scanner  scan = new Scanner(file); // scans the file


        while (scan.hasNext()) { // while the scanner identifies student names
            final String name = scan.next();

            int nbGrades = 0;
            int totalGrades = 0;

            while (scan.hasNextInt()) { //while the scanner identifies grades
                int grade = scan.nextInt();

                nbGrades++;
                totalGrades += grade;
            }

            // declare average variable and calculate it
            final BigDecimal average = new BigDecimal(totalGrades).divide(new BigDecimal(nbGrades));

            System.out.println("Name:" + name + " Average:" + average);
        }
    } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}