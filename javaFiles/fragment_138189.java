@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == ADD_REQUEST_CODE) {
        if (resultCode == ADD_REQUEST_CODE) {
            Log.i("ListViewActivity", "Returned onActivityResult");
            TodoObj todoObj = (TodoObj) data.getParcelableExtra("EXTRA_TODO");
            Toast.makeText(ListViewActivity.this, "" + todoObj.getmYear(),
                    Toast.LENGTH_SHORT).show();
        }
    }
}