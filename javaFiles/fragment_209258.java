public void onClick(View v) {
    final GMailSender sender = new GMailSender("username@gmail.com", "password");
    new AsyncTask<Void, Void, Void>() {
        @Override public Void doInBackground(Void... arg) {
            try {   
                sender.sendMail("This is Subject",   
                    "This is Body",   
                    "user@gmail.com",   
                    "user@yahoo.com");   
            } catch (Exception e) {   
                Log.e("SendMail", e.getMessage(), e);   
            } 
        }
    }.execute();
}