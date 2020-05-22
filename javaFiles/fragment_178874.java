String[] spBifrost = res.getStringArray(R.array.spBifrost);
StringBuilder stringbuffer = new StringBuilder();
for(String item : str_arr) {
  stringbuffer.append(item).append(";");
}
return itemQuantitySP.getString(key, stringbuffer.toString());