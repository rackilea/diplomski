SimpleDateFormat formatDate = new SimpleDateFormat("dd MMM,yyyy");
SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
String inputDateStr = jsonObject.getString(ConfigPost.TAG_POST_DATE);
try {
    Date inputDate = inputFormat.parse(inputDateStr);             
    String postDateStr = formatDate.format(inputDate); 
    postItem.setPost_date(postDateStr);
} catch (ParseException e) {
     Log.d(TAG, "Error in Parsing date");
}