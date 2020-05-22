@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
super.onActivityResult(requestCode, resultCode, data);
if (Build.VERSION.SDK_INT == Build.VERSION_CODES.M){
        final Uri data = intent.getData();
        final File file = new File(data.getPath());
        // your code
}else{
       // your code
}