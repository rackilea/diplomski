{

    if (requestCode == 1) {
        if(resultCode == RESULT_OK){
            String result=data.getStringExtra("result");
        }
        if (resultCode == RESULT_CANCELED) {
            //Write your code if there's no result
        }
    }
}//onActivityResult