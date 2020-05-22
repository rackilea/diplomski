if(j==args.length){

        // ...

        while(j<=args.length && isCorrect ){
            System.out.println(++j + "" + questions[j] + "\t" + "Correct" + "\t" + count + "/" + questions[j].length() + " Correct guesses" + "\t" + noInvalidTry + "/" + questions[j].length() + " Incorrect guesses" );
            temp++;
        }
        while(j<=args.length && !isCorrect) {
            System.out.println(++j + ". " + questions[j] + "\t" + "Incorrect" + "\t" + count + "/" + questions[j].length() + " Correct guesses" + "\t" + noInvalidTry + "/" + questions[j].length() + " Incorrect guesses" );
        }