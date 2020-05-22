jObject = new JSONObject(result);
  if (jObject.has("error")) 
  { 
      String aJsonString = jObject.getString("error");
      Toast.makeText(getBaseContext(), aJsonString, Toast.LENGTH_SHORT).show(); 
  }
  else 
  { 
      Toast.makeText(getBaseContext(), "Login Successful", Toast.LENGTH_SHORT).show(); 
  }
  }
  catch (JSONException e1) { 
      // TODO Auto-generated catch block 
      e1.printStackTrace(); 
      Toast.makeText(getBaseContext(),result+"" , Toast.LENGTH_SHORT).show();
   }