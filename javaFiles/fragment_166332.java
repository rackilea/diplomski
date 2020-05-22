List<AnswerRow> lista = new ArrayList<AnswerRow>();

    while(rs.next()){

        String answerText = rs.getString("answerText");
        boolean isRight = rs.getBoolean("answerRight");

        //Create AnswerRow instance and set values to it and Add it to list.
        AnswersTableModel .AnswerRow ansrow = atm.new AnswerRow();
        ansrow.setAnswer(answerText);
        ansrow.setRight(isRight);

       //Add it to list.
       lista.add(ansrow);
    }