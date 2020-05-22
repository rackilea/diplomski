JSONObject jsonObject = this.dataArray.getJSONObject(position);
String yelpStr = jsonObject.optString("yelp");
if(yelpStr != null){
    infoHolder.yelp.setText(yelpStr);
    infoHolder.yelp.setVisibility(View.VISIBLE);
    Toast.makeText(activity, "Yelp Here", Toast.LENGTH_LONG).show();
}else{
    infoHolder.yelp.setVisibility(View.GONE);
    Toast.makeText(activity, "Yelp Gone", Toast.LENGTH_LONG).show();
}