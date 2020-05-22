try {
    JSONArray jArray = new JSONArray(text2);
    String []fields = { "name","callingCodes","capital","region","population"};
    for (int i=0;i<jArray.length();i++){
        JSONObject obj = jArray.getJSONObject(i);
        for (int i=0 ;i < fields.length; i++) {
            tv.append(fields[i] + " = " + obj.getString(fields[i]) + "\n");

            if (fields[i].equalsIgnoreCase("flag")) {

               Picasso.with(c)
              .load("https://media1.britannica.com/eb-media/54/69554-004- 
               3E298C44.jpg")
              .placeholder(R.drawable.ic_android_temp)
              .error(R.drawable.ic_error)
              .into(img);
            }
         }
     }
} catch (Exception e) {
    e.printStackTrace();
}