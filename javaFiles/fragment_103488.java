Handler mHandler = new Handler() {
    @Override
    public void handleMessage(Message msg) {
        ValueMsg t = (ValueMsg) msg.obj;
        // this is where you handle the data you sent. You get it by calling the      getReading() function
        mResponseField.setText(&quot;Flag: &quot;+t.getFlag()+&quot;; Reading: &quot;+t.getReading()+&quot;; Date: &quot;+(new Date().toString()));
    }