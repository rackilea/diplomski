public class LogTag {
  public  static void d(String msg){
    if (ApplicationClass.isDebug){
        Log.d("log_tag", msg);
    }
  }

  public  static void v(String msg){
    if (ApplicationClass.isDebug){
        Log.v("log_tag", msg);
    }
  }
  public  static void e(String msg,Exception e){
    if (ApplicationClass.isDebug){
        Log.e("log_tag", msg, e);
    }
  }
  public  static void e(String msg){
    if (ApplicationClass.isDebug){
        Log.e("log_tag", msg);
    }
  }
}