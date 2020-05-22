@Override
protected void onActivityResult(int requestCode,int resultCode, Intent data) {
    if(requestCode == 200) {
        if(resultCode == RESULT_OK) {
            int position = data.getIntExtra("position",0);
            HashMap<String,String> items = (HashMap<String,String>) data.getSerializableExtra("taskItems");

            taskItems.set(position, items);
            adapter.notifyDatasetChanged();

        }
        if (resultCode == RESULT_CANCELED) {

        }
    }
}