char [] correctAnswers = {'A', 'B', 'C', 'A'};
Scanner in = new Scanner(System.in);

for(int i = 0; i < correctAnswers; i ++){
    System.out.println("Please input answer:");
    String valueString = in.nextLine().toUpperCase();
    if(valueString.length() != 1){
        System.out.println("Answer invalid. Please only type one character");
        i--;
    } else {
        char answer = valueString.charAt(0);
        if(correctAnswers[i] == answer)
            System.out.println("Correct");
        else
            System.out.println("Wrong");
    }
}