@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    if (requestCode == 100) {
        if(resultCode == Activity.RESULT_OK){
            //do something
        }
        if (resultCode == Activity.RESULT_CANCELED) {
            //do something if there's no result
        }
    }
}