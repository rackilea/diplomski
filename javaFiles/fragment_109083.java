String stringToParse  = "[{'name':'test','description':'','dbType':'sql'}, "
            + "{'name':'test1','description':'','dbType':'sql server'},"
            + "{'name':'test2','description':'','dbType':'sql oracle'}]";


JSONParser parser = new JSONParser();
JSONArray json = (JSONArray) parser.parse(stringToParse);