int correct = 0;
while(correct < 4) {
    int userNumbers = input.nextInt();
    if (userNumbers < length) {
        char randomWord = userWord.charAt(userNumbers);
        System.out.println(randomWord);
        correct++;
    } else {
        System.out.println("All indices must be less than your word.");
    }
}