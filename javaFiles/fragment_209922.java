HashMap<Integer,Object> hashMap = new HashMap<Integer, Object>();
private OnItemSelectedListener itemSelectListener = new OnItemSelectedListener() {

   @Override
   public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3) {   
       System.out.println("parent Tag:"+arg0.getTag());
       TextView itemName = (TextView)findViewById(Integer.parseInt(arg0.getTag().toString()));
       System.out.println("Item Name:" +itemName.getText().toString());
       System.out.println("Item Price:" +itemName.getTag().toString());
       System.out.println("Item QTY:" +arg0.getItemAtPosition(arg2).toString());
       orderItems = new OrderItems();
       if(!"".equals(arg0.getItemAtPosition(arg2).toString())){
          orderItems.itemName = itemName.getText().toString();
          orderItems.itemPrice = itemName.getTag().toString();
          orderItems.noOfItems = Integer.parseInt(arg0.getItemAtPosition(arg2).toString());
          hashMap.put(arg2,orderItems);
       }
   }

   @Override
   public void onNothingSelected(AdapterView<?> arg0) {

   }
};