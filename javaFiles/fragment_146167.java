Intent appIntent;
...

appIntent=new Intent(this,Chooser.class);
            startActivityForResult(appIntent, 1);



...


 @Override
     protected void onActivityResult(int requestCode, int resultCode, Intent data)
     {

       super.onActivityResult(requestCode, resultCode, data);

       if(null!=data){

         if(requestCode==1){
            //Do something
           String message=data.getStringExtra("MESSAGE_package_name");
           package_Name.SetText(message);
         }
     }