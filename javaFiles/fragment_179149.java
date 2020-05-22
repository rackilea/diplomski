StringBuilder responseStrBuilder = new StringBuilder();

String inputStr;
while ((inputStr = br.readLine()) != null)
    responseStrBuilder.append(inputStr);
JSONObject obj = new JSONObject(responseStrBuilder.toString());
String title = obj.getString("original_title");