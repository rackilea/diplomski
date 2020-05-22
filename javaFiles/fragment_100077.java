List<EmployeeBean>questionList=adao.displayQuestions(eBean,functional_id);
   model.addObject("questionList", questionList);

   List<List<EmployeeBean>> resultList = new ArrayList<>();
   Iterator<EmployeeBean> iterator = questionList.iterator();
   while (iterator.hasNext()) {
          String q_id = iterator.next().getSk_question_id();
          System.out.println("QUESTION ID :"+q_id);
          resultList.add(adao.displayOptions(eBean,q_id));//store it by index
   }
   model.addObject("optionList", resultList);