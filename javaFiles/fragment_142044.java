private ProgressDialog progressDialog() {
    progress= new ProgressDialog(this);
    progress.setIndeterminate(true);
    progress.setMessage("I am thinking");
    return progress;
}
private String postData() {
    try{
    Thread.sleep(1000);
    }
    catch(Exception e){;}
    Log.d(TAG,"postData");
    return "done";
}
private void sentDialog() {
    Toast.makeText(Main.this,"Sent", Toast.LENGTH_SHORT).show();
}