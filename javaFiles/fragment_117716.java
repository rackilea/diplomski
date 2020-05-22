while (( line = buffreader.readLine()) != null) {
        //System.out.println(line);
        try 
        {
        _db.execSQL(line);
        }
        catch(Exception e)
        {}
    }