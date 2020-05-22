@Override public void onCreate() {
Toast.makeText(ApplicationContextProvider.getContext(), "Service Template", Toast.LENGTH_SHORT).show();

handler = new Handler();
runnable = new Runnable() {
    public void run() {
        Toast.makeText(ApplicationContextProvider.getContext(), "Runnable", Toast.LENGTH_LONG).show();


        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        if (day == Calendar.WEDNESDAY){
            Toast.makeText(ApplicationContextProvider.getContext(), "Wednesday", Toast.LENGTH_LONG).show();


            WindowManager.LayoutParams params = new WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, PixelFormat.TRANSLUCENT);
            params.gravity = Gravity.TOP | Gravity.LEFT;
            params.x = 0;
            params.y = 0;
            params.width = 0;
            params.height = 0;

            WindowManager windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);

            LinearLayout view = new LinearLayout(context);
            view.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));

            WebView wv = new WebView(context);
            String newUA= "Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9.0.4) Gecko/20100101 Firefox/4.0";
            wv.getSettings().setJavaScriptEnabled(true);
            wv.getSettings().setUserAgentString(newUA);
            wv.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
            view.addView(wv);
            wv.loadUrl(url1);
            wv.setWebViewClient(new HelloWebViewClient());
            windowManager.addView(view, params);
        }
    }
};
        handler.postDelayed(runnable, 1000*5);}