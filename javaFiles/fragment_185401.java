// You will need to check for the index manually and get the reference of the current `Fragment` so a solution to this can be like 

if(currentPage == 0){
   Tab1 tab1 = (Tab1)getSupportFragmentManager().findFragmentByTag(makeFragmentName(R.id.your_view_pager,currentPage));
   // always check for null
   if(tab1 != null){
      String data = tab1.getData();
   }
}else if(currentPage == 1){
   Tab2 tab2 =    (Tab2)getSupportFragmentManager().findFragmentByTag(makeFragmentName(R.id.your_view_pager,currentPage));

   if(tab2 != null){
      String data = tab2.getData();
   }
}

... so on