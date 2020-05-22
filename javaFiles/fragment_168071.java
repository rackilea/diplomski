String response = "{\"album\":[{\"name\":\"DD Y Ponle Play\",\"artist\":\"Jumbo\",\"id\":\"2528039\",\"url\":\"http://www.last.fm/music/Jumbo/DD+Y+Ponle+Play\",\"image\":[{\"#text\":\"http://images.amazon.com/images/P/B00005LN6S.01._SCMZZZZZZZ_.jpg\",\"size\":\"small\"},{\"#text\":\"http://images.amazon.com/images/P/B00005LN6S.01._SCMZZZZZZZ_.jpg\",\"size\":\"medium\"},{\"#text\":\"http://images.amazon.com/images/P/B00005LN6S.01._SCMZZZZZZZ_.jpg\",\"size\":\"large\"},{\"#text\":\"http://images.amazon.com/images/P/B00005LN6S.01._SCMZZZZZZZ_.jpg\",\"size\":\"extralarge\"}]}]}";

    JSONObject myObject = new JSONObject(response);
    JSONArray myArray = myObject.getJSONArray( "album" );

    for(int i=0; i<myArray.length(); i++)
    {
        JSONObject myIterator = myArray.getJSONObject( i );
        JSONArray arrayOne = myIterator.getJSONArray( "image" );

        for(int j=0; j<arrayOne.length(); j++)
        {
            JSONObject myInnerIterator = arrayOne.getJSONObject( j );               
            if(myInnerIterator.has( "size" ))//check if 'size' key is present
                if(myInnerIterator.getString( "size" ).equalsIgnoreCase( "medium" ))
                    System.out.println( myInnerIterator.getString( "#text" ) );
        }
    }