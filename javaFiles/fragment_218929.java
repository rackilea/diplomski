public class getdata extends AsyncTask<Void, Void, Void> {
    private Context mcontext;
    private String message;

    Checks checks = null;
    getdata(Context context, String msg) {
        this.mcontext = context;
        this.message = msg;
        checks = new Checks(mcontext);
    }

    @Override
    protected Void doInBackground(Void... params) throws IllegalStateException {
        System.out.println("Starting");

        TelephonyManager telephonyManager = (TelephonyManager)   mContext.getSystemService(Context.TELEPHONY_SERVICE);
        String id = telephonyManager.getDeviceId();
        System.out.println(id);
        try {
            if (checks.checkinternet()) {
                Log.i("Internet Status","Found");
            }
        }