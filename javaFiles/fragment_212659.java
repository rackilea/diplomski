public class NotificationService extends Service {
// constant
public static final long NOTIFY_INTERVAL = 30 * 1000; // 30 seconds
long current_times;
String c_time;
// run on another Thread to avoid crash
private Handler mHandler = new Handler();
// timer handling
static HttpClient client = new DefaultHttpClient();
private Timer mTimer = null;

@Override
public IBinder onBind(Intent intent) {
    return null;
}

@TargetApi(Build.VERSION_CODES.GINGERBREAD) @SuppressLint("NewApi") @Override
public void onCreate() {
    // cancel if already existed

    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
    StrictMode.setThreadPolicy(policy);
    SharedPreferences.Editor editor = getSharedPreferences("notification_oldtime", MODE_PRIVATE).edit();

     editor.putInt("old_trail_time", 0);
     editor.putInt("old_sample_time", 0);
     editor.putInt("old_neworder_time", 0);

     editor.commit();

    if(mTimer != null) {
        mTimer.cancel();
    } else {
        // recreate new
        mTimer = new Timer();
    }
    // schedule task
    mTimer.scheduleAtFixedRate(new TimeDisplayTimerTask(), 0, NOTIFY_INTERVAL);
}

public long current_time_get(){

    return current_times;

}





class TimeDisplayTimerTask extends TimerTask {

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN) @Override
    public void run() {
        // run on another thread

        mHandler.post(new Runnable() {

            @Override
            public void run() {
                // display toast

                DBAdapter.init(getApplicationContext());
                SharedPreferences prefs = getSharedPreferences("notification_oldtime", MODE_PRIVATE); 
                SharedPreferences.Editor editor = getSharedPreferences("notification_oldtime", MODE_PRIVATE).edit();

                int sample_order_new_count=0,trail_order_new_count=0,new_order_new_count=0,old_sample_order_count=0,old_trail_order_count=0,old_new_order_count=0;
                String      search_read_URL=DBAdapter.getUrlName()+"/web/dataset/search_read";
                JSONArray sample_jsonarray,trail_jsonarray,new_jsonarray;

                JSONObject jsonObj_sample,jsonObj_trail,jsonObj_newOrder;
                StringEntity sample_entity,new_order_entity,trail_entity;
                String responseBody_sample,responseBody_Trail,responseBody_NewOrder;

            ResponseHandler<String> responseHandler = new BasicResponseHandler();

            try{

                DBAdapter.init(getApplicationContext());
                //  notification for sample order
                HttpPost sample_get = new HttpPost(search_read_URL);
                HttpPost new_order_get = new HttpPost(search_read_URL);
                HttpPost trail_get = new HttpPost(search_read_URL);
                Log.d("service","start");
                sample_entity = new StringEntity(" {\"jsonrpc\":\"2.0\",\"method\":\"call\",\"params\":{\"model\":\"sale.sample.order\",\"fields\":[\"partner_id\",\"distributor_id\",\"marketing_person_id\",\"__last_update\"],\"domain\":[],\"context\":{\"lang\":\"en_US\",\"tz\":false,\"uid\":"+Integer.valueOf(DBAdapter.getMarketPersonUid())+",\"params\":{\"page\":0,\"limit\":500,\"view_type\":\"list\",\"model\":\"sale.sample.order\",\"menu_id\":378,\"action\":446,\"_push_me\":false},\"bin_size\":true},\"offset\":0,\"limit\":500,\"sort\":\"\"},\"id\":780343122}");
                new_order_entity=new StringEntity("{\"jsonrpc\":\"2.0\",\"method\":\"call\",\"params\":{\"model\":\"new.order.log\",\"fields\":[\"name\",\"partner_id\",\"distributor_id\",\"marketing_person_id\",\"__last_update\"],\"domain\":[],\"context\":{\"lang\":\"en_US\",\"tz\":false,\"uid\":"+Integer.valueOf(DBAdapter.getMarketPersonUid())+",\"params\":{\"page\":0,\"limit\":500,\"view_type\":\"list\",\"model\":\"new.order.log\",\"menu_id\":355,\"action\":418,\"_push_me\":false},\"bin_size\":true},\"offset\":0,\"limit\":500,\"sort\":\"\"},\"id\":674827326}");
               trail_entity=new StringEntity("{\"jsonrpc\":\"2.0\",\"method\":\"call\",\"params\":{\"model\":\"leather.trial.order\",\"fields\":[\"partner_id\",\"distributor_id\",\"marketing_person_id\",\"__last_update\"],\"domain\":[],\"context\":{\"lang\":\"en_US\",\"tz\":false,\"uid\":"+Integer.valueOf(DBAdapter.getMarketPersonUid())+",\"params\":{\"page\":0,\"limit\":500,\"view_type\":\"list\",\"model\":\"leather.trial.order\",\"menu_id\":375,\"action\":442,\"_push_me\":false},\"bin_size\":true},\"offset\":0,\"limit\":500,\"sort\":\"\"},\"id\":455581058}");

                sample_get.setHeader("Content-Type", "application/json");
                sample_get.setHeader("Cookie:","session_id="+DBAdapter.getSessionId());
                sample_get.setEntity(sample_entity);

                new_order_get.setHeader("Content-Type", "application/json");
                new_order_get.setHeader("Cookie:","session_id="+DBAdapter.getSessionId());
                new_order_get.setEntity(new_order_entity);

                trail_get.setHeader("Content-Type", "application/json");
                trail_get.setHeader("Cookie:","session_id="+DBAdapter.getSessionId());
                trail_get.setEntity(trail_entity);


                responseBody_sample = client.execute(sample_get, responseHandler);
                jsonObj_sample = new JSONObject(responseBody_sample);
                JSONObject json=jsonObj_sample.getJSONObject("result"); 
                sample_jsonarray = json.getJSONArray("records");                    

                responseBody_Trail=client.execute(trail_get, responseHandler);
                jsonObj_trail=new JSONObject(responseBody_Trail);
                JSONObject json1=jsonObj_trail.getJSONObject("result"); 
                trail_jsonarray = json1.getJSONArray("records");                    

                responseBody_NewOrder=client.execute(new_order_get,responseHandler);
                jsonObj_newOrder=new JSONObject(responseBody_NewOrder);
                JSONObject json2=jsonObj_newOrder.getJSONObject("result");
                new_jsonarray=json2.getJSONArray("records");

                long server_Time = 0;

                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);


                String new_order_name="",trail_order_name="",sample_order_name="";

                 for (int m = 0; m <trail_jsonarray.length(); m++) {
                  JSONObject c =  trail_jsonarray.getJSONObject(m);
                  JSONArray cus_json_array=c.getJSONArray( "partner_id");
                  JSONArray market_person_json_array=c.getJSONArray( "marketing_person_id");
                   Date date = format.parse(String.valueOf(c.getString("__last_update")));
                   server_Time = date.getTime();

                 DBAdapter.init(getApplicationContext());
                 long current_time=Long.parseLong(DBAdapter.getCurrentTime());
                 Log.d("trail ct"+current_time,"st"+server_Time); 
                 if(server_Time>current_time){
                     trail_order_new_count++;
                     Log.d("trail_order cus name",cus_json_array.getString(1));
                     trail_order_name=trail_order_name+" "+"Customer="+cus_json_array.getString(1)+"\n"+"Marketing Person="+market_person_json_array.getString(1);
                }
                 else{
                     m=trail_jsonarray.length();
                 }

               }

                 for (int m = 0; m <sample_jsonarray.length(); m++) {
                     JSONObject c = sample_jsonarray.getJSONObject(m);
                     JSONArray cus_json_array=c.getJSONArray( "partner_id");
                     JSONArray market_person_json_array=c.getJSONArray( "marketing_person_id");
                   Date date = format.parse(String.valueOf(c.getString("__last_update")));
                   server_Time = date.getTime();

                 DBAdapter.init(getApplicationContext());
                 long current_time=Long.parseLong(DBAdapter.getCurrentTime());
                 Log.d("sample ct"+current_time,"st"+server_Time); 
                    if(server_Time>current_time){
                     sample_order_new_count++;
                     Log.d("sample_order cus name",cus_json_array.getString(1));
                     sample_order_name=sample_order_name+" "+"Customer="+cus_json_array.getString(1)+"\nMarketing Person="+market_person_json_array.getString(1);
                    }

                 else{
                     m=trail_jsonarray.length();
                 }

                  }

                 for (int m = 0; m <new_jsonarray.length(); m++) {
                     JSONObject c =  new_jsonarray.getJSONObject(m);
                     JSONArray cus_json_array=c.getJSONArray( "partner_id");
                     JSONArray market_person_json_array=c.getJSONArray( "marketing_person_id");
                   Date date = format.parse(String.valueOf(c.getString("__last_update")));
                   server_Time = date.getTime();

                 DBAdapter.init(getApplicationContext());
                 long current_time=Long.parseLong(DBAdapter.getCurrentTime());
                 Log.d("newOrder ct"+current_time,"st"+server_Time); 
                 if(server_Time>current_time){
                     new_order_new_count++;
                     Log.d("new_order cus name",cus_json_array.getString(1));
                     new_order_name=new_order_name+" "+"Customer="+cus_json_array.getString(1)+"\nMarketing Person="+market_person_json_array.getString(1);
                    }

                 else{
                     m=trail_jsonarray.length();
                 }

                  }

               int newOrder_ID=100,sampleOrder_ID=200,trailOrder_ID=300;
               final NotificationManager mgr=
                          (NotificationManager)getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
                    PendingIntent i2=PendingIntent.getActivity(getApplicationContext(), 1,
                         new Intent(getApplicationContext(),MainActivity.class),
                         0);

                Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);



                if (new_order_new_count>prefs.getInt("old_neworder_time", 0)) {
                          NotificationCompat.Builder  mBuilder = new NotificationCompat.Builder(getApplicationContext()); 
                          mBuilder .setStyle(new NotificationCompat.BigTextStyle().bigText(new_order_name));
                          mBuilder.setContentText(new_order_name);
                          mBuilder.setContentTitle(new_order_new_count+" New Orders");
                          mBuilder.setSmallIcon(R.drawable.bkg_new_logo);
                          //mBuilder.setNumber(++numMsg);
                          mBuilder.setContentIntent(i2);
                          Log.d(String.valueOf(old_new_order_count),String.valueOf(new_order_new_count));
                          if(old_new_order_count!=new_order_new_count){
                          mBuilder.setSound(alarmSound);
                          }
                          mgr.notify(newOrder_ID, mBuilder.build());
                          old_new_order_count=new_order_new_count;
                       editor.putInt("old_neworder_time", new_order_new_count);
                      editor.commit();
                    }
              if (sample_order_new_count>prefs.getInt("old_sample_time", 0)) {
                      NotificationCompat.Builder  mBuilder = new NotificationCompat.Builder(getApplicationContext()); 
                      mBuilder .setStyle(new NotificationCompat.BigTextStyle().bigText(sample_order_name));
                      mBuilder.setContentText(sample_order_name);
                      mBuilder.setContentTitle(sample_order_new_count+" Sample Orders");
                      mBuilder.setSmallIcon(R.drawable.bkg_new_logo);
                      //mBuilder.setNumber(++numMsg);
                      mBuilder.setContentIntent(i2);
                      if(old_sample_order_count!=sample_order_new_count){
                      mBuilder.setSound(alarmSound);
                      }
                      mgr.notify(sampleOrder_ID, mBuilder.build());
                      old_sample_order_count=sample_order_new_count;
                      editor.putInt("old_sample_time", sample_order_new_count);
                      editor.commit();
              } 
             if (trail_order_new_count>prefs.getInt("old_trail_time", 0)) {
                  NotificationCompat.Builder  mBuilder = new NotificationCompat.Builder(getApplicationContext()); 
                  mBuilder .setStyle(new NotificationCompat.BigTextStyle().bigText(trail_order_name));
                  mBuilder.setContentText(trail_order_name);
                  mBuilder.setContentTitle(trail_order_new_count+" Trail Orders");
                  mBuilder.setSmallIcon(R.drawable.bkg_new_logo);
                  //mBuilder.setNumber(++numMsg);
                  mBuilder.setContentIntent(i2);
                  if(old_trail_order_count!=trail_order_new_count){
                  mBuilder.setSound(alarmSound);
                  }
                  mgr.notify(trailOrder_ID, mBuilder.build());
                  old_trail_order_count=trail_order_new_count;



                  editor.putInt("old_trail_time", trail_order_new_count);
                  editor.commit();
             }   

            }
               catch(Exception e){
                   e.printStackTrace();
               }
               }

        });
    }



}
}