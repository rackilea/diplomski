while ( (s = bufferedReader.readLine() ) != null)

    {
        String[] stringsArr = s.split(",");


        jsonObject.put( "famname" , stringsArr[0] );
        jsonObject.put("name" , stringsArr[1]);
        jsonObject.put("id", stringsArr[2]);

        //*************
        bufferedReader.close(); // don't close the reader!
        //*************

    }