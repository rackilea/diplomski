List<String> questions = new ArrayList<>();

try {
    ...
    for (int i = 0; i < jsonArray.length(); i++) {
        ...
        questions.add(jsonObj.getString("question"));
        ...
    }

} catch (JSONException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}

String myjsonstring = sb.toString();

// Check if questions have been fetched
if (questions.size() > 0) {
    txt_questionAdjective = (TextView) findViewById(R.id.txt_questionAdjective);
    // Use the first question
    txt_questionAdjective.setText(questions.get(0));
}