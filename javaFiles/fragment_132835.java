Bundle extras = getIntent().getExtras();
if (extras != null) {
    String componentName = extras.getString(RESTAURANT_ID);

    Intent intent = new Intent(this, TableActivity.class);
    intent.putExtra(RESTAURANT_ID, componentName);
    startActivity(intent);
}