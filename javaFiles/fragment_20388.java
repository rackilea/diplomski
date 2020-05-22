button.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View view) {
       if (isfirstTime) {
           // call here first time action
           isfirstTime=false;
       }else {
          // call here second time action
         // make isfirstTime = true; 
         // if you want to perform again first time action after second time use press the button
       }


     }
});