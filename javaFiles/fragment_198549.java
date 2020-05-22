@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
           if(requestCode == 0) {
            // handling code of startActivityForResult of first button
           Bundle basket = data.getExtras();
             s = basket.getString("arnswer");
            }
           if(requestCode == 1) {
            // handling code of startActivityForResult of second button
            Bundle basket = data.getExtras();
             s1 = basket.getString("arnswer");
             }

        }
    }