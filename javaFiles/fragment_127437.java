JSONObject mainObject = null;
    try 
    {
        mainObject = new JSONObject(stringBuilder.toString());
        JSONArray jsonArrayPDF = mainObject.getJSONArray("pdfs");

        for (int i = 0; i < jsonArrayPDF.length(); i++) {

        JSONObject object = jsonArrayPDF.getJSONObject(i);
        Video video=new Video();
        String url = object.getString("url");

        String titolo = object.getString("titolo");
        String sottotitolo = object.getString("sottotitolo");
        String data = object.getString("data");
        //video.setId(idd4);
        System.out.println("CAZZO:"+video.getId());
        video.setPic(url);
        video.setTitolo(titolo);
        video.setSottotitolo(sottotitolo);
        video.setData(data);

        videoList.add(video);

    }

    } 
    catch (JSONException e) 
   {
        e.printStackTrace();
    }