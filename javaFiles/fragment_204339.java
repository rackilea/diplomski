@Override
public void onClick(View view) {
//give your intent a name to reference from("moreDetail" in this case)
Intent moreDetail = new Intent(SearchActivity.this,MoreDetail.class);
//attach the intent reference to access each item and key 
moreDetail.putExtra(MoreDetail.EXTRA_POSITION,single_view);                       
startActivity(moreDetail);//Start the new activity