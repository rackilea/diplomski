@Override
public void onResume() {
    super.onResume();

    asm_view.onResume(); //remember to add this so your WebView can resume

    //Coloring the "recent apps" tab header; doing it onResume, as an insurance
    if (Build.VERSION.SDK_INT >= 23) {
        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        ActivityManager.TaskDescription taskDesc;
        taskDesc = new ActivityManager.TaskDescription(getString(R.string.app_name), bm, getColor(R.color.colorPrimary));
        MainActivity.this.setTaskDescription(taskDesc);
    }
    get_location();
}

@Ovveride 
public void onPause() {
    super.onPause();
    asw_view.onPause(); //your WebView variable is asm_view, not mWebView, which is just example code
}