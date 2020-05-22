public boolean isNetworkActive() {
    try {
     Process ping = java.lang.Runtime.getRuntime().exec("ping -c 1 www.google.com");
     return ping.waitFor()==0? true : false;
    } catch (final java.io.IOException | InterruptedException e) {
       return false;
    }

}