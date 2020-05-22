int score = 0;
do {
        System.out.printf("Enter a score (0 too 100, -1 to quit #%d:)", studentCount);
        score = stdin.nextInt();         
        if (score > 100 || score < -1) {
            System.out.println("Illegal Score Try Again");
            continue;
        }
        studentCount++;
        total += score;
} while (score != -1);