public List<Question> getQuestions(TestCallBack testCallBack) { 

 public void onResponse(JSONArray response) {

 testCallBack.callBack(questionArrayList); // pass your array list here
 }

}