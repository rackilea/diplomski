JSONObject j = new JSONObject(ParsedString);
    JSONArray pictureFiles = j.getJSONArray("layout");

    for (int i = 0; i < pictureFiles.length(); i++ ){  
     JSONArray ja = pictureFiles.getJSONArray(i);
        for(int j=0;j<ja.length();j++){
          mJpegNames.add("http://www.simongrey.net/08027/slidingPuzzleAcw/images/"+ metadata+"/"+ ja.getString(j));
    }