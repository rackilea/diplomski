@Override
protected void onActivityResult(int requestCode, int resultCode, Intent resultIntent) {
    if (requestCode == ARRIVAL_REQUEST_CODE) {
        if (resultCode == RESULT_OK) {
            String arrivalValue = resultIntent.getStringExtra("ArrivalListViewClickedValue");
            arrive.setText(arrivalValue);    // You can make 'arrive' instance variable and initialize it in onCreate
        }
    }
}