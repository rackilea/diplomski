tabs!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{

     override fun onTabSelected(tab: TabLayout.Tab?) {
         viewPager!!.currentItem = tab?.position!!    
         if (tab.position == 0) {
             //like this: tabs.setSelectedTabIndicatorColor(Color.BLUE)
             //or like this:  tabs.getTabAt(0)!!.getIcon()!!.setAlpha(100)

         }else if (tab.position == 1) {

         }
     }

})