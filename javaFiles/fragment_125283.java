try{
       int sum = 0; // you don't need the totalPrice variable, they will hold the same result 
       for (int i=0;i<jsonObj.length(); i++) {
        String itemInArray = jsonObj.getString(String.valueOf(i));
        int itemPrice = Integer.ParseInt(itemInArray);
        sum = sum + itemPrice;
      }
    }catch (JSONException e) {
      e.printStackTrace();
    }