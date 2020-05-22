public static String isNetworkReachable(){
    int timeout = 2000;
    String status = "ERROR";
    try {
        InetAddress address = InetAddress.getByName("10.2.240.74");

        if(address.isReachable(timeout)){
            status = "SUCCESS";
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return status;

}