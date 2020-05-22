public void testCatalogLinkContent(){
        //VERIFY USER IS ON HOMEPAGE
        try {
            solo.sleep(3000);
            assertTrue(solo.searchText("Apps")) ;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        //CLICK ON CATALOG      
        try{
            solo.clickOnText("Apps");
                }catch(Exception e){
                    e.printStackTrace();
                }
        //Search for Music in menu
        if(solo.searchText(RECOMMENDED)==false){
            Log.e(TAG, RECOMMENDED + " Not found!!!"); 

        }else{
            Log.i(TAG, RECOMMENDED + " Found"); 
        }

        //Search for UAT  in menu
        if(solo.searchText(UAT)==false){
            Log.e(TAG,  UAT + " Not found!!!"); 

        }else{
            Log.i(TAG, UAT  + " Found"); 
        }

        //Search for  NEW APPS in menu
        if(solo.searchText(NEW)==false){
            Log.e(TAG, NEW  + " Not found!!!"); 

        }else{
            Log.i(TAG, NEW + " Found"); 
        }

        //Search for TOP SELLERS in menu
        if(solo.searchText(TOPSELLER)==false){
            Log.e(TAG, TOPSELLER + " Not found!!!"); 

        }else{
            Log.i(TAG, TOPSELLER + " Found"); 
        }
        //Search for top downloaded
        if(solo.searchText(TOPDOWNLOAD)==false){
            Log.e(TAG, TOPDOWNLOAD  + " Not found!!!"); 

        }else{
            Log.i(TAG, TOPDOWNLOAD  + " Found"); 
        }

        //Search for EA in menu
        if(solo.searchText(EA)==false){
            Log.e(TAG, EA  + " Not found!!!"); 

        }else{
            Log.i(TAG, EA  + " Found"); 
        }
        solo.scrollUp();
        //Search for FEATURED in menu
        if(solo.searchText(FEATURED)==false){
            Log.e(TAG, FEATURED + " Not found!!!"); 

        }else{
            Log.i(TAG, FEATURED + " Found"); 
        }
        solo.scrollUp();
        //Search for GAMES in menu
        if(solo.searchText(GAMES)==false){
            Log.e(TAG, GAMES + " Not found!!!"); 

        }else{
            Log.i(TAG, GAMES + " Found"); 
        }
        solo.scrollUp();
        //Search for APPS in menu
        if(solo.searchText(APPS)==false){
            Log.e(TAG, APPS + " Not found!!!"); 

        }else{
            Log.i(TAG, APPS  + " Found"); 
        }
        solo.scrollUp();
        //Search for SOCIAL  in menu
        if(solo.searchText(SOCIAL)==false){
            Log.e(TAG, SOCIAL + " Not found!!!"); 

        }else{
            Log.i(TAG, SOCIAL  + " Found"); 
        }
        solo.scrollUp();
        //Search for ENTERTAINMENT in menu
        if(solo.searchText(ENTERTAINMENT)==false){
            Log.e(TAG, ENTERTAINMENT + " Not found!!!"); 

        }else{
            Log.i(TAG,ENTERTAINMENT  + " Found"); 
        }
        solo.scrollUp();
        //Search for MUSIC  in menu
                if(solo.searchText(MUSIC)==false){
                    Log.e(TAG, MUSIC  + " Not found!!!"); 

                }else{
                    Log.i(TAG, MUSIC  + " Found"); 
                }
                solo.scrollUp();
        //Search for THEMES  in menu
        if(solo.searchText(THEMES)==false){
            Log.e(TAG, THEMES  + " Not found!!!"); 

        }else{
            Log.i(TAG, THEMES  + " Found"); 
        }
        solo.scrollUp();
        //Search for TOOLS  in menu
        if(solo.searchText(TOOLS)==false){
            Log.e(TAG, TOOLS + " Not found!!!"); 

        }else{
            Log.i(TAG, TOOLS  + " Found"); 
        }
        solo.scrollUp();
        //Search for  NEWSin menu
        if(solo.searchText(NEWS)==false){
            Log.e(TAG, NEWS  + " Not found!!!"); 

        }else{
            Log.i(TAG, NEWS + " Found"); 
        }
        solo.scrollUp();
        //Search for SPORTS  in menu
                if(solo.searchText(SPORTS)==false){
                    Log.e(TAG, SPORTS  + " Not found!!!"); 

                }else{
                    Log.i(TAG, SPORTS  + " Found"); 
                }
                solo.scrollUp();
        //Search for READING in menu
        if(solo.searchText(READING)==false){
            Log.e(TAG, READING + " Not found!!!"); 

        }else{
            Log.i(TAG, READING + " Found"); 
        }
        solo.scrollUp();
        //Search for MONEY in menu
        if(solo.searchText(MONEY)==false){
            Log.e(TAG, MONEY + " Not found!!!"); 

        }else{
            Log.i(TAG, MONEY + " Found"); 
        }
        //Search for SHOPPING in menu
        if(solo.searchText(SHOPPING)==false){
            Log.e(TAG, SHOPPING  + " Not found!!!"); 

        }else{
            Log.i(TAG, SHOPPING  + " Found"); 
        }
        //Search for FITNESS in menu
        if(solo.searchText(FITNESS)==false){
            Log.e(TAG, FITNESS + " Not found!!!"); 

        }else{
            Log.i(TAG, FITNESS  + " Found"); 
        }
        //Search for TRAVEL  in menu
        if(solo.searchText(TRAVEL)==false){
            Log.e(TAG,TRAVEL + " Not found!!!"); 

        }else{
            Log.i(TAG, TRAVEL  + " Found"); 
        }
        //Search for BUSINESS  in menu
        if(solo.searchText(BUSINESS)==false){
            Log.e(TAG, BUSINESS + " Not found!!!"); 

        }else{
            Log.i(TAG, BUSINESS  + " Found"); 
        }
        //Search for SPANISH in menu
        if(solo.searchText(SPANISH)==false){
            Log.e(TAG, SPANISH + " Not found!!!"); 

        }else{
            Log.i(TAG, SPANISH + " Found"); 
        }
    }