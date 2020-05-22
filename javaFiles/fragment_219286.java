public static void main(String args[]) {
JSONObject TP1 = new JSONObject();
String[] alias = {"topping","cake"};
String[] entityType = {"Topping","cake"};
String[] textString = {"pizza","pancake"};
String[] usersays_text = {"I want ","I want "};

JSONObject jobj = new JSONObject();
JSONArray jarr = new JSONArray();


for(int index = 0; index < usersays_text.length; index++)   
{
    JSONObject parts = new JSONObject();
    JSONArray partsArr = new JSONArray();
    JSONObject partsObj = new JSONObject();
    partsObj.put("text", usersays_text[index].toString());
    JSONObject cont = new JSONObject();
    cont.put("alias", alias[index].toString());
    cont.put("text", textString[index].toString());
    cont.put("entityType", entityType[index].toString());
    partsArr.put(partsObj);
    partsArr.put(cont);
    parts.put("parts", partsArr);
    jarr.put(parts);
}

jobj.put("trainingPhrases", jarr);
System.out.println(jobj.toString(4)); 
}