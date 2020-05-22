String yourJSONString = "{"code":1,"data":{"survey":{"id":null,"questionAnswers":[{"id":null,"min":"1","max":"5","step":"0.1","last":"4.7","text":"I am happy at work today","key":"Mood","testQuestionId":"1","datetime":"2014-04-29 15:47:02","answer":"4.7","testAnswerId":null}]}}}";

JSONObject jObj_main = new JSONObject(yourJSONString);
JSONObject jOb_data = jObj_main.getJSONObject("data");
JSONObject jOb_survey = jOb_data.getJSONObject("survey");
JSONArray jArray_questionAnswers = jOb_survey.getJSONArray("questionAnswers");