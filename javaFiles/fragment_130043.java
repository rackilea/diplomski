ConnectivityManager conectivtyManager = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);  
if (conectivtyManager.getActiveNetworkInfo() != null  
    && conectivtyManager.getActiveNetworkInfo().isAvailable()  
    && conectivtyManager.getActiveNetworkInfo().isConnected()) {  
    isConnected = true;  
} else {  
    isConnected= false;  
}