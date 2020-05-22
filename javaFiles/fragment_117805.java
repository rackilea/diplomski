public void onItemClick(AdapterView<?> a,View v,int position,long id){
        info.open();
        String Pdata = info.getRows(id);
        openInfo.putExtra("data",Pdata);
        info.close();
        //Start the Activity
        startActivity(openInfo);
    }