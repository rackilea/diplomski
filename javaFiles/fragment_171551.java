public static void inputScores(String newFile) {
        Scanner scan = new Scanner(System.in);
        Formatter write=null;
        try {
            write = new Formatter(newFile + ".txt");
            double score = 0.0;
            int count = 1;
            while(true) {
                try {
                System.out.println("Please enter student " + count + "'s test score, input -1 to quit:\n>");
                score = scan.nextDouble();
                count++;
                if(score>=0)
                    write.format("%.2f%n", score);
                else
                    break;
                }catch (InputMismatchException e) {
                    System.err.println("Invalid input, Student's scores must be a number");
                    scan.next();
                    System.out.println();
                }
            }
            write.close();
            scan.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }