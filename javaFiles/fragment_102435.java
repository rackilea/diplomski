package org.sample;

    import android.app.Activity;
    import android.app.ProgressDialog;
    import android.os.Bundle;
    import android.os.Handler;

    public class Hello extends Activity {

        private Handler handler;
        private ProgressDialog dialog;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            dialog = new ProgressDialog(this);
            dialog.setMessage("Please Wait!!");
            dialog.setCancelable(false);
            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dialog.show();

            new Thread() {
                public void run() {
                    // Do operation here.
                    // ...
                    // ...
                    // and then mark handler to notify to main thread 
                    // to  remove  progressbar
                    //
                    // handler.sendEmptyMessage(0);
                    //
                    // Or if you want to access UI elements here then
                    //
                    // runOnUiThread(new Runnable() {
                    //
                    //     public void run() {
                    //         Now here you can interact 
                    //         with ui elemements.
                    //
                    //     }
                    // });
                }
            }.start();

            handler = new Handler() {
                public void handleMessage(android.os.Message msg) {
                    dialog.dismiss();
                };
            };
        }
    }