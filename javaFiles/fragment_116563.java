//get tab number
  final Intent intent = getIntent();
        if (intent.hasExtra("TabNumber")) {
            String tab = intent.getExtras().getString("TabNumber");
            Log.e("TabNumberFriendList",tab);
            switchToTab(tab);
        }
 public void switchToTab(String tab){
         if(tab.equals("0")){
             viewPager.setCurrentItem(0);
         }else if(tab.equals("1")){
             viewPager.setCurrentItem(1);
         }else if(tab.equals("2")){
             viewPager.setCurrentItem(2);
         }
     }