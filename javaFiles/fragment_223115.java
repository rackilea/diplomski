int questionNumber = question.displayQuestion(1);
        int player1Answer = keyboard.nextInt();

        if (player1Answer == question.getCorrectAnswer(questionNumber))
        {
            System.out.println("That is correct!");
            player1Points ++;
        }
        else System.out.println ("Sorry the correct answer was "+question.getCorrectAnswer(questionNumber));

        int questionNumberForPlayer2 =  question.displayQuestion(2);
        int player2Answer = keyboard.nextInt();

        if (player2Answer == question.getCorrectAnswer(questionNumberForPlayer2))
        {
            System.out.println("That is correct!");
            player2Points ++;
        }
        else System.out.println ("Sorry the correct answer was "+question.getCorrectAnswer(questionNumberForPlayer2));

    }