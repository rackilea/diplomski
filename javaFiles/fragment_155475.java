JSONObject json = new JSONObject(yourdata);
String statistics = json.getString("statistics");

for (Iterator key=json.keys();key.hasNext();) {
    JSONObject name = json.get(key.next());
    //now name contains the firstname, and so on... 
}