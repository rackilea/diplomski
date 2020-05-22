List<MyListData> myListData = new ArrayList<MyListData>();
myListData.add(new MyListData("Email", android.R.drawable.ic_dialog_email,"mg",android.R.drawable.ic_dialog_email));

...
Integer n = 0;
while (n < 10){ 
   JSONObject dump  = reader.getJSONObject(n.toString());
   JSONObject dump2  = dump.getJSONObject("info");
   myListData.add(new MyListData("Email", android.R.drawable.ic_dialog_email,"mg",android.R.drawable.ic_dialog_email))
   n++;
}