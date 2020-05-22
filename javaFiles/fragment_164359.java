//--dedicated thread to run tasks one after another--
private final ExecutorService s = Executors.newSingleThreadExecutor();

//--handle incoming sms--
public void handleSms(final String input, final SQLiteDatabase db){
    s.submit(new Runnable() {
        @Override
        public void run() {
            //--do stuff with input and db
        }
    });
}