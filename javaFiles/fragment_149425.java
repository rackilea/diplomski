public void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == 1) {
        if(resultCode == RESULT_OK){

          String newText = data.getStringExtra("newText");
          int itemPosition = data.getIntExtra("position");

          //Pass these values to adapter through `updateItem` method
            adapter.updateItem(newText, itemPosition);
        }
    }
}