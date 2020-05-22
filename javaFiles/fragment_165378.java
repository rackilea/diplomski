while(temp!=null){          
            teststring=temp;
             temp=br.readLine();
            System.out.println(teststring);             

        JSONTokener jsonParser = new JSONTokener(teststring);  
        JSONObject  jsonobject=new JSONObject(jsonParser);      

        JSONObject VotejsonObject = jsonobject.getJSONObject("votes");                  
        System.out.println(VotejsonObject.getInt("funny")); 
        System.out.println(VotejsonObject.getInt("useful")); 
        System.out.println(VotejsonObject.getInt("cool"));       
        System.out.println(jsonobject.getString("user_id"));
        System.out.println(jsonobject.getString("review_id"));
        System.out.println(jsonobject.getInt("stars"));
        System.out.println(jsonobject.getString("date"));
        System.out.println(jsonobject.getString("text"));
        System.out.println(jsonobject.getString("type"));
        System.out.println(jsonobject.getString("business_id"));
        }