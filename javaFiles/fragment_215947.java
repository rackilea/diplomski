RcpApi2.getInstance().setOnRcpEventListener(this);

try {
    RcpApi2.open();      

} catch (Exception e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}