JSONObject myJSONObject = new JSONObject("Your resultstring goes here");
JSONObject resultObject = myJSONObject.getJSONObject("result");
JSONObject FirstDataObject = resultObject.getJSONObject("FirstData"); //Object with JSONObjects "One","Two" etc


//Since the part " {"One": 1, "Two": 2,..." in your string isn't an JSONArray you cannot do the following but if it were like this "["One": 1, "Two": 2,..." your could do this:

JSONArray FirstDataArray = resultObject.getJSONObject("FirstData"); //Array with JSONObjects "One","Two" etc

JSONArray arr = resultObject.getJSONArray("FirstData"); 
for (int i = 0; i < arr.length(); i++)
{
    String number = arr.getJSONObject(i).getString(0);
    ......
}