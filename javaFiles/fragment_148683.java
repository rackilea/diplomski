Button btn=(Button)vi.findViewById(R.id.btnAdd);
  btn.setOnClickListener(new OnClickListener(){

    public void onClick(View arg0) {
            // TODO Auto-generated method stub


        AlertDialog.Builder ab=new AlertDialog.Builder(MainActivity.this);
        ab.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
           @Override 
           public void onClick(DialogInterface dialog, int which) {
              String facebookFriendName = friendsName.getText().toString();
                    String FACEBOOKID = FBID;
                   Log.i("AKO SI: ", ""+facebookFriendName + FACEBOOKID);
           }
        });
        ab.setNegativeButton("No", new DialogInterface.OnClickListener(){
               @Override 
               public void onClick(DialogInterface dialog, int which) {

               }
            });
        ab.show();                       
    }                
});