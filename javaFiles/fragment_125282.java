for (int i = 0; i < jsonObj.length(); i++) {
     try {                                  
       String itemInArray = jsonObj.getString(String.valueOf(i));
       int Sum =  0;
       int totalPrice = sum + itemInArray;

     } catch (JSONException e) {
      e.printStackTrace();
    }

  }