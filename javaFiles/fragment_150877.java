JSONObject jsonObject = jsonArray.getJSONObject(i).getJSONObject("video");
if(jsonObject.has("status")){
  // ignore video object

}else{
  //... get other thumbnail, player objects
}