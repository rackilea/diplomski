@Override
protected void onCreate(Bundle savedInstanceState) {
    CheckBox buttonShare;
    buttonShare = findViewById(R.id.button_shared);
    buttonShare.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            shareWallpaper();
        }
    });
}