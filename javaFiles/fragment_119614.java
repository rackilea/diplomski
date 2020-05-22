public static void presentQuestion(Scanner input, NumericQuestion q) {
        boolean userCorrect = false;
        boolean isAnswerNumeric = false;
        String answer = null;
        while(! isAnswerNumeric){
            q.displayQuestion();
            System.out.println("Enter your answer (numeric only) : ");
            answer = input.nextLine();
            try{
                Double.parseDouble(answer);
                isAnswerNumeric = true;
            }catch(NumberFormatException nfe){
               // do nothing in this case.. if the number format is correct, 
               // the isAnswerNumeric will be set to true
            }
        }
        userCorrect = q.checkAnswer(answer);
        if (userCorrect){
            System.out.println("Correct! The answer is : " + q.getAnswer() + " and you have a score of : " + q.getMark());
        } else {
            System.out.println(answer + " is incorrect. You scored zero.");
        }
        System.out.println();
}