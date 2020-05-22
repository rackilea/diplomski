void menu() {
    for (;;) {
        System.out.println("1. Take Quiz");
        System.out.println("2. Quiz Results");
        System.out.println("3. Performance Comment");
        System.out.println("4. Exit");
        System.out.print("Choose from the above:");
        byte menu = Keyboard.readByte();
        switch (menu) {
            case 1:
                takeQuiz();
            case 2:
                quizResults();
            case 3:
                performanceComment();
            case 4:
                break;
        }
    }
}