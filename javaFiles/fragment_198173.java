myfile.saveInBackground(new SaveCallback() {
public void done(ParseException e) {
if (e == null) {
    myObjectSavedSuccessfully();
} else {
   Log.d("Error",e.toString())
}
}
});