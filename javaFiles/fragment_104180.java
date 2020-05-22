public void sendEmail(Context context){ 
        Intent sendEmail = new Intent(Intent.ACTION_SEND_MULTIPLE); 

         //set data to intent
         context.startActivity(Intent.createChooser(sendEmail, "Send")); 
     }