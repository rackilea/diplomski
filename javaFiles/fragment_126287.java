@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    switch(requestCode){
    case PICKFILE_RESULT_CODE:
        if(resultCode==RESULT_OK){
            String FilePath = data.getData().getPath();
            ...
        }
        break;
    }
}