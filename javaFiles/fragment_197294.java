for(List l : db.getAllAnswersByQuestion1()){
           for(String s : l){
                StringTokenizer tokens = new StringTokenizer(s, ",");
        String first = tokens.nextToken();
        String second = tokens.nextToken();

        questionView.setText(first);
        answerText1.setText(second);
           }
 }