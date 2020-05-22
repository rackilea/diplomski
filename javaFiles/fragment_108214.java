Intent cameFrom = getIntent();
if(cameFrom != null){
  //Here your intent isn't null now let's check for the values
   if(cameFrom.hasExtra("Category1")){
       cameFrom.getStringExtra("Category1");
   }else if(cameFrom.hasExtra("Category2")){
       cameFrom.getStringExtra("Category2");
   }else{
      //Nothing Found
   }
}