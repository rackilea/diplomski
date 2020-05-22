button.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         try{
             if (v.getId() == R.id.button) {
                  //Send Message to Server
             }else {
                  throw new serverExceptionerror ("Server hasn't connected"); 
             } 
         }
         catch (serverExceptionerror ex) { 
             Toast.makeText(ex.getMessage(),Toast.LENGTH_LONG).show();
         }
     }
}