public JSONObject file_upload1(String URL, String userid, String topic_id,
        String topicname, String filelist, List<String> taglist,
        String textComment, String textLink) {
    JSONObject jObj = null;
    // Making HTTP request
    try {
        // defaultHttpClient
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(URL);

        FileBody bin = null;
        MultipartEntity reqEntity = new MultipartEntity(
                HttpMultipartMode.BROWSER_COMPATIBLE);


            File file = new File(filelist);
            System.out.println("file name" + filelist.get(i));


            try {
                bin = new FileBody(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
            reqEntity.addPart("post_data" + i, bin);

        }

        for (int i = 0; i < taglist.size(); i++) {
            reqEntity.addPart("dtype" + i, new StringBody(taglist.get(i)));
        }

        reqEntity.addPart("tag", new StringBody("savetopicactivities"));
        reqEntity.addPart("user_id", new StringBody(userid));
        reqEntity.addPart("text", new StringBody(textComment));
        reqEntity.addPart("count",
                new StringBody(String.valueOf(taglist.size())));
        reqEntity.addPart("topic_id", new StringBody(topic_id));
        reqEntity.addPart("topic_name", new StringBody(topicname));
        reqEntity.addPart("link", new StringBody(textLink));

        httpPost.setEntity(reqEntity);

        HttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity httpEntity = httpResponse.getEntity();
        is = httpEntity.getContent();

    } catch (Exception e) {
        e.printStackTrace();
    }

    try {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                is, "iso-8859-1"), 8);
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line + "\n");
        }
        json = sb.toString();
        System.out.println("json   " + json);
        try {
            jObj = new JSONObject(json);
        } catch (Exception e) {

            e.printStackTrace();
        }

        is.close();

    } catch (Exception e) {
        Log.e("Buffer Error", "Error converting result " + e.toString());
    }

    // return JSON String
    return jObj;
}