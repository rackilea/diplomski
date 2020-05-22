String myList = obj.get("list").toString();
     list1 = gson.fromJson(myList, collectionType); // delete this not required

     JSONArray obj1 = new JSONArray(list1);
     JSONObject numbersObject = obj1.getJsonObject(0); // change this to get first object from the JsonArray
     String mobileList = 
        numbersObject.get("storeMobileNumbers").toString();
        mobileNumbers = gson.fromJson(mobileList, collection2);