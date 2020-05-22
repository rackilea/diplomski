public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_items, menu);
       if (hideIcon){
          menu.findItem(R.id.action_share).setVisible(false);
       }else{
          menu.findItem(R.id.action_share).setVisible(true);
       }
        return true;
    }