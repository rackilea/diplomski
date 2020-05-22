if(jsonObject.isNull("parentId"))
    {
        System.out.println("inside null");
        jsonObject.put("parentId", 0);
    }
    else
    {
        System.out.println("inside else part");
        //jsonObject.put("parentId", jsonObject.getInt("parentId"));
        jsonObject.put("parentId", 0);
    }