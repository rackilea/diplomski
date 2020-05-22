for (int i = 0; i < responseArray.length(); i++) {
Questions questions = new Questions();
                                JSONObject response = responseArray.getJSONObject(i);
      Log.v("Naveen", response.toString());                       
                                questions.setId(response.getInt("employee_id"));
                                questions.setQuestions(response.getString("name"));
                                questions.setOption1(response.getString("dob"));
                                questions.setOption2(response.getString("designation"));
                                questions.setOption3(response.getString("contact_number"));
                                questions.setAnswerNr(response.getInt("email"));
                                questions.setDifficulty(response.getString("salary"));

                                contactLists.add(questions);
                                Log.v("Kumar", contactLists.toString());