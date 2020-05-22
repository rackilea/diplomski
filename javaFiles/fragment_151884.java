private String URL = null;
     try{
            URL = com.fttech.AbstractFeedsActivity.feed_url;
            if(TextUtils.isEmpty(URL)){
                 URL = com.fttech.ItemsActivity.url;
                 // Pass this URL   
            }
            else{
              // If its not empty then it will pass the first URL
          }
        }
        catch(IllegalArgumentException e){
            e.printStackTrace();
        }