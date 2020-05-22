//global variable
boolean imagePicked = false;


//In onActivityResult change its value
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK
            && null != data) {
        imagePicked = true;
        //other things
    }
    else {
        imagePicked = false;
        //other things
    }