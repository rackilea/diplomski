@Override
public void onClick(View v) {
    if(v.getId()==submit_btn.getId()) {
        new LongNetworkOperation.execute();
    }
}