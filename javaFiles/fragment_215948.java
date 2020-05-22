RCPApi2 rcpAPI = RCPApi2.getInstance();
rcpAPI.setOnRcpEventListener(this);

try {
    rcpAPI.open();             


} catch (Exception e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}