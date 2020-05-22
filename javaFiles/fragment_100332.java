private Activity activity;

 @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (Activity) context;
        utils = new Utils(context);
    }