private static final String LOG_TAG = "CustomLayout";


public CustomLayout() {
}

public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

    if (action.equals("alert")) {
        this.alert();
        return true;
    }
    return false;
}

public synchronized void alert() {
    final CordovaInterface cordova = this.cordova;

    Runnable runnable = new Runnable() {
        public void run() {
            AlertDialog.Builder dlg = new AlertDialog.Builder(cordova.getActivity(), AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
            Application app = cordova.getActivity().getApplication();
            String package_name = app.getPackageName();
            Resources resources = app.getResources();

            int layout = resources.getIdentifier("customlayout", "layout", package_name);
            int image = resources.getIdentifier("tvDragMe", "id", package_name);

            LayoutInflater inflater =  cordova.getActivity().getLayoutInflater();
            View customview = inflater.inflate(layout, null);
            dlg.setView(customview);
            ImageView motion = (ImageView) customview.findViewById(image);
            motion.setOnTouchListener(new MyTouchListener());
            dlg.create();
            dlg.show();
        };
    };
    this.cordova.getActivity().runOnUiThread(runnable);
}

private class MyTouchListener implements View.OnTouchListener {
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
            view.startDrag(data, shadowBuilder, view, 0);
            view.setVisibility(View.INVISIBLE);
            return true;
        } else {
            return false;
        }
    }
}