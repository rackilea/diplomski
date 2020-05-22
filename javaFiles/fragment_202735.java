private Handler handler = new Handler() {
    @Override

    public void handleMessage(Message msg) {
    // perform logic
    if(LoadingDialog!=null)//first check if dialog is not null.This might be a reason for crashing
     LoadingDialog.dismiss();
    LoadingDialog=null
    }

    };