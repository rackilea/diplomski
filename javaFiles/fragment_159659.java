class MyOnClickListener implements OnClickListener {
    public void onClick(View v) {
        final CharSequence[] items = {"1", "2", "3"};
        AlertDialog.Builder builder = new AlertDialog.Builder(SlovnikoidActivity.this);
        builder.setTitle("test");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_SHORT).show();
                langFrom.setText(items[item]);
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}