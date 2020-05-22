protected void onMessage(Context context, Intent intent) {                      
    Log.i(TAG, "Recieved");
    String message = intent.getExtras().getString("price");                         
    String oo[] = message.split("-");                                           
    int length = oo.length;
    String kk = "R";
    String msg = length > 3 ? oo[3] : "";
    String che = length > 2 ? oo[2] : "";
    see = length >1 oo[1] : "";

    if (kk.equals(oo[0])) {                 

        RandomMsg.test = msg;
        RandomMsg.pool= see;
    } else {


    display(context, message);                  
}
}