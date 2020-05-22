public void generateQuestion() {
    int min = 0;
    int max = 1;
    Random r = new Random();
    int questionToBeSelected = r.nextInt(max - min + 1) + min;
    System.out.println(questionToBeSelected);
    String[] easy1 = {
            "In The Phantom Menace, who are the first two characters on screen?", //Question, obviously
            "3", //The array child that is correct
            "Padme and Annie", //Answer 1
            "Obi-Wan and Qui-Gon Jinn", //Answer 2
            "Jar Jar Binks", //Answer 3
            "Annie and Obi-Wan" //Answer 4
    };
    String[] easy2 = {
            "Sample question",
            "2", // array index that is correct
            "Sample answer",
            "Wrong answer1",
            "Wrong answer2",
            "Wrong answer3",
    };
    String[] questionName = new String[][]{easy1, easy2}[questionToBeSelected];
    System.out.println(easy1[0]);
    TextView questionPlaceholder = (TextView) findViewById(R.id.game_question);
    System.out.println(questionName[0]);
    questionPlaceholder.setText(questionName[0]);  //   <-------- Problem :(
    String alreadyPlayedQuestions;
    String questionNumber;
}