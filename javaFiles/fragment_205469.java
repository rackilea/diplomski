String mImei = null; 
 TelephonyManager mTeleManager = null; 
 mTeleManager = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE); 
 //Here this refers to activity context
 if(mTeleManager!=null){
  mImei = mTeleManager.getDeviceId(); //get the IMEI number
 }