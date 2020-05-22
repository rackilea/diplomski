List<Quizmodel> mQuizList = new ArrayList<>();
    String mQuestion = new String();
    mQuestion = "Ask Question Here ?";
    List<String> mOptionsList = new ArrayList<>();
    mOptionsList.add("A1");
    mOptionsList.add("A2");
    mOptionsList.add("A3");

    Quizmodel mModel = new Quizmodel();
    mModel.setmQuestion(mQuestion);
    mModel.setmOptions(mOptionsList);
     mModel.setmAnswer("A2");

    mQuizList.add(mModel);

    //String m = "";
    for (int ind = 0; ind < mQuizList.size(); ind++) {
        System.out.println(mQuizList.get(ind).getmQuestion());
        //  Log.v("response",mQuizList.get(ind).getmQuestion());
        for (int index = 0; index < mQuizList.get(ind).getmAnswers().size(); index++) {
            System.out.print(mQuizList.get(ind).mAnswers.get(index) + " ");
           // m = m + mQuizList.get(ind).mAnswers.get(index) + " ";
        }
System.out.println(mQuizList.get(ind).getmAnswer());
    }