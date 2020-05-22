Button btnBack = (Button) findViewById (R.id.btnBack);
btnBack.setOnClickListener (new OnClickListener () {

    @Override
    public void onClick (View v) {
        message = "";
        for(int i = 0 ; i < color.length ; i++){
             if(color[i].getTag().toString().equals("1")){
                  message = message + "#" + color[i].getContentDescription();
             }
        }
        if (ctr >= 1) {
            Toast.makeText (Filter.this, message, Toast.LENGTH_SHORT).show();
            message = "";
        } 
        //finish();
    }
});