scan.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
         Intent myIntent = new Intent(MainActivity.this,
                        ScanActivity.class);
         startActivityForResult(myIntent ,111);
    }
});