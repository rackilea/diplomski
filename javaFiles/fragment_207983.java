ImageView iv1 = (ImageView) dialog.findViewById(R.id.imgFB);
iv1.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {

        // set the flag
        chooserIsShowing = true;

        Uri uri = Uri.parse("https://www.facebook.com/PagesByZ");); 
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        dialog.cancel();
        startActivity(intent);
    }
});