public static void permuteString(String beginningString, String endingString) {

        String[] answers = new String[4];
        answers[0] = "OS";
        answers[1] = "GOOD";
        answers[2] = "CS";
        answers[3] = "Cody";

        List<String> answersList = Arrays.asList(answers);
        Collections.shuffle(answersList);
        System.out.println(Arrays.toString(answersList.toArray(new String[0])));

    }