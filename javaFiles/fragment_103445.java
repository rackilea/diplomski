public void order(View v) {

    String result="";
    Integer a=0;
    int r=0; // You can use either 'a' or 'r' for addition.

    ArrayList<ListItem> res=getListItem();
    List<Integer> resultList=adapter.getCheckedItemPosition();
    for (int i = 0; i < resultList.size(); i++) {
        a+=res.get(resultList.get(i)).getPrice(); 
    }
    result="Total:"+a;
    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();

}