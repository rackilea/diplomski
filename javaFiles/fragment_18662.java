private void parseJsonFeed(String response) {
    try {
        JSONObject jsonObj = new JSONObject(response);
        JSONArray feedArray = jsonObj.getJSONArray("data");
        for (int i = 0; i < feedArray.length(); i++) {
            JSONObject feedObj = (JSONObject) feedArray.get(i);

            QuestionsItem item = new QuestionsItem();
            item.setId(feedObj.getInt("id"));
            item.setQuestion(feedObj.getString("question"));
            String options = feedObj.getString("multi_ans_option");
            String[] parts = options.split("\\|");
            String part1 = parts[0];
            String part2 = parts[1];
            String part3 = parts[2];
            String part4 = parts[3];
            item.setAnsOne(part1);
            item.setAnsTwo(part2);
            item.setAnsThree(part3);
            item.setAnsFour(part4);
            item.setAnswer(feedObj.getString("answer"));
            timeLineItems.add(item);

            listView.setAdapter(adapter);  //Paste Here
        }

        // notify data changes to list adapater
        adapter.notifyDataSetChanged();


    } catch (JSONException e) {
        e.printStackTrace();
    }
}