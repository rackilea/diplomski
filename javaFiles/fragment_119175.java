file = new ParseFile("profile_pic.jpg", image);

file.saveInBackground(new SaveCallback() {
   public void done(ParseException e) {
       // If successful add file to user and signUpInBackground
   }
});