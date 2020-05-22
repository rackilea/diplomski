JSONArray QCM = response.getJSONArray("QCM");
    for (int i = 0; i < QCM.length(); i++) {
        JSONObject getQcmObject = QCM.getJSONObject(i);
        String questionGet = getQcmObject.getString("question");
        symptomesQuestions.setText(questionGet);
        JSONArray choiceGet = getChoixObject.getJSONArray("choix");
        lesChoixButton1.setText(choiceGet.getString(0));
        lesChoixButton2.setText(choiceGet.getString(1));
    }