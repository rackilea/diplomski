Scanner sc = new Scanner(System.in);
    int bestScore = Integer.MIN_VALUE;
    String team = "Nothing entered";
    System.out.println("how many teams");
    int count = sc.nextInt();
    sc.nextLine();
    while (count-- > 0) {
        System.out.println("Entered team,score");

        String line = sc.nextLine();
        String arr [] = line.split(" ");
        // check size - TBD
        if (Integer.parseInt(arr[1]) > bestScore) {
            bestScore = Integer.parseInt(arr[1]);
            team = arr[0];
        }
    }

    System.out.println("nest team is " + team + " with a score of " + bestScore);