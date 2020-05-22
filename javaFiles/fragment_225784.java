char [] correctAnswers = {'A', 'B', 'C', 'A'};
Scanner in = new Scanner(System.in);
System.out.println("Please input " + correctAnswers.length + " answer(s):");
String answerString = in.nextLine().toUpperCase();

if(answerString.length() != correctAnswers.length){
    System.out.println("Incorrect number of answers entered");
} else {
    for(int i = 0; i < answerString.length; i ++){
        if(correctAnswers[i] == answerString.charAt(i)){
            System.out.println("Answer " + (i + 1) + " Correct");
        } else {
            System.out.println("Answer " + (i + 1) + " Wrong");
        }
        count ++;
    }
}