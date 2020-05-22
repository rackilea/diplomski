private ProgressDialog progress;
private Handler myHandler= new Handler(){
    @Override
    public void  handleMessage(Message msg){         
        switch(msg.what){
            case 0:
                progress.dismiss();
                sentDialog();
                break;
            default:
                super.handleMessage(msg);
                break;
        }
    }
};