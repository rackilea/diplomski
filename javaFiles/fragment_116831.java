String json = data.toString();
        int length = json.length();

        for(int i=0; i<length; i+=1024)
        {
            if(i+1024<length)
                Log.d("JSON OUTPUT", json.substring(i, i+1024));
            else
                Log.d("JSON OUTPUT", json.substring(i, length));
        }