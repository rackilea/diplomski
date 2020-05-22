protected void onPostExecute(String result) {

    if(result.equals("Admin login success")){

         Intent intent = new Intent(context, adminpanel.class);
         context.startActivity(intent);
    }
    if(result.equals("Student Login Success")){

     Intent intent = new Intent(context, studentpanel.class);
    context.startActivity(intent);
   }
    else
    {
        alertDialog.setMessage(result);
        alertDialog.show();
    }
}