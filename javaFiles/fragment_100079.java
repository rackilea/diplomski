List<EmployeeBean>questionList=adao.displayQuestions(eBean,functional_id);
   model.addObject("questionList", questionList);

   int index = 0;
   while (iterator.hasNext()) {
          String q_id = iterator.next().getSk_question_id();
          System.out.println("QUESTION ID :"+q_id);
          model.addObject("optionList_"+index,adao.displayOptions(eBean,q_id));
          index++;
   }