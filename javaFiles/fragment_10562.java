@Override
public void onCreate() {
    Toast.makeText(this,"Service Started", Toast.LENGTH_LONG).show();

    myTimer = new Timer();
    myTimer.schedule(new TimerTask() {
        @Override
        public void run() {

            String fo = userInfoHashmap.get(TAG_FOLLOWED_BY);
            try {
                lilParser();
            }
                catch (IOException e) {e.printStackTrace();}
                catch (JSONException e) {e.printStackTrace();}

      if(new String(userInfoHashmap.get(TAG_FOLLOWED_BY)).equals(fo)==true){}
      else {
          getnotification();

      }
        }
    }, 0, 30000);
}