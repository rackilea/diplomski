public boolean writeJSON(Customer c, String yourSettingName)
{
   try {
       String writeValue = mGson.toJson(c);
       mEditor.putString(yourSettingName, writeValue);
       mEditor.commit();
       return true;
   }
   catch(Exception e)
   {
       return false;
   }
}

public Customer readJSON(String yourSettingName)
{
   String loadValue = mSettings.getString(yourSettingName, "");
   Customer c = mGson.fromJson(loadValue, Customer.class);
   return c;
}