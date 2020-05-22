if (input.hasNextDouble()) {
    double userNum = input.nextDouble();
    if (userNum == additionAnswer) {
        System.out.println("That's correct!");
    } else {
        System.out.println("The correct solution is: " + additionAnswer);
    }
} else {
    System.out.println("All solutions must be entered as decimal numbers");
}