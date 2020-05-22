public void onDestroy(){
    Intent myIntent = new Intent(this,
            MyACtivity.class);
    myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    getApplication().startActivity(myIntent);
}