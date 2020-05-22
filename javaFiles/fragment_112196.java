isCheckEmail("yourEmail@test.com",new OnEmailCheckListener(){
   onSucess(boolean isRegistered){

     if(isRegistered){
           //The email was registered before
    } else {
           //The email not registered before
    }

   }
});