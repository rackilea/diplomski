@Override
public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menu_layout, menu);
    //getMenuInflater().inflate(R.menu.menu_layout, menu); you can remove this inflate
    MenuItem item = menu.findItem(R.id.spinner);
    Spinner spinner = (Spinner) getActionView(item);
    ArrayAdapter<CharSequence> adapter = new ArrayAdapter<>(OrderDetailsDisplayActivity.this, android.R.layout.simple_spinner_dropdown_item, getResources().getTextArray(R.array.status_names));
    spinner.setAdapter(adapter); // set the adapter to provide layout of rows and content
    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            switch (i) {
                case ORDER_RECEIVED:
                    Toast.makeText(OrderDetailsDisplayActivity.this, "Order recieved", Toast.LENGTH_SHORT).show();
                    break;
                case ORDER_CONFIRMED:
                    Toast.makeText(OrderDetailsDisplayActivity.this, "Order confirmed", Toast.LENGTH_SHORT).show();
                    break;
                case ORDER_COMPLETED:
                    Toast.makeText(OrderDetailsDisplayActivity.this, "Order completed", Toast.LENGTH_SHORT).show();
                    break;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    });
    return true;
}