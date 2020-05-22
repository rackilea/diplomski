ArrayList<String> mParsedList = new ArrayList<String>();
    JSONAarry responseArr=new JSONArray(responseJSON);
    for(int i=0;i<responseArr.length;i++)
    {
       String temp=responseArr.getString(i);// get one by one element 
       myProduct.add(new Product(temp,2,R.drawable.user_awake,responseJSON));
  }