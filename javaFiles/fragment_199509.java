btnList.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        //Goes to the list activity
        Intent intentList = new Intent(MainActivity.this, ListActivity.class);
        intentList.putExtra("WINENAME", new ArrayList<String>());     // Empty list
        intentList.putExtra("WINEPRICE", Arrays.asList("Foo", "Bar")); // Explicit list named items
        intentList.putExtra("WINEDESCRIPTION", getDescriptions());    // Get list from private method
        startActivity(intentList);
    }
});