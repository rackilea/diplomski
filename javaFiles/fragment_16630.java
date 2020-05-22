try {
// info node
JSONObject objInfo = new JSONObject();
objInfo.put("name", name);
objInfo.put("email", email);
objInfo.put("phone", phone);

// itemname1 node
JSONObject itemname1 = new JSONObject();
itemname1.put("unitprice", unitprice1);
itemname1.put("qty", qty1);

// itemname2 node
JSONObject itemname2 = new JSONObject();
itemname2.put("unitprice", unitprice2);
itemname2.put("qty", qty2);

// item node
JSONObject item = new JSONObject();

// adding itemname1 & itemname2 to item
item.put("itemname1",itemname1);
item.put("itemname2",itemname2);

// root node
JSONObject root = new JSONObject();
root.put("info",objInfo);
root.put("item",item);

System.out.print(root);

} catch(JsonException e){
     e.printStackTrace();
}