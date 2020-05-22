JSONArray var=objects.get(0).getJSONArray("itemDetails");
Log.d(TAG_NAME,"object itemDetails:"+var);
Log.d(TAG_NAME,"length of var is"+var.length());
Log.d(TAG_NAME,"1st element:"+var.get(0));
for (int i=0;i<var.length();i++){
JSONArray dynamicArray=(JSONArray)var.get(i);
for (int j=0;j<dynamicArray.length();j++){
    if(j==0){
        itemNames=itemNames+dynamicArray.get(j).toString();
        if (i<var.length()-1){
            itemNames = itemNames + ",";
        }
    }else if (j==1){
        itemsQuantity=itemsQuantity+Integer.parseInt((String) dynamicArray.get(j));
    }else if (j==2){
        itemsPrice=itemsPrice+Double.parseDouble((String) dynamicArray.get(j));
    }
}
}