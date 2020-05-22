import java.io.File;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class WipeSDActivity extends Activity {

      private static ProgressDialog progressBar;
      private static int progressBarStatus = 0;
      private static Handler progressBarHandler = new Handler();      
      public Button btnwipe_sd;
      private int fileCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.sd_card);

    btnwipe_sd = (Button)findViewById(R.id.wipe_button);
    btnwipe_sd.setOnClickListener(new OnClickListener()
    {
          public void onClick(final View view)
          {

              new AlertDialog.Builder(WipeSDActivity.this).setCancelable(true)
              .setMessage("This will attempt to wipe all directories and files on your SD card.")
              .setPositiveButton("WIPE", new DialogInterface.OnClickListener()
              {
                public void onClick(DialogInterface dialog, int which)
                {
                  dialog.dismiss();
                  FormatSDCard(view);
                }
              }).setNegativeButton("NO!", new DialogInterface.OnClickListener()
              {
                public void onClick(DialogInterface dialog, int which)
                {
                  dialog.dismiss();
                }
              }).show();
          }
        });
    }


    public void FormatSDCard(View v){
        progressBar = new ProgressDialog(v.getContext());
        progressBar.setCancelable(false);
        progressBar.setMessage("File deleting ...");
        progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressBar.setProgress(0);
        progressBar.setMax(100);
        progressBar.show();

        new Thread(new Runnable() {
            public void run() {
                while (progressBarStatus < 100) {
                    //fileCount = 0;
                    // process some tasks
                    progressBarStatus = wipingSdcard();
                    // your computer is too fast, sleep 1 second
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // Update the progress bar
                    progressBarHandler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(progressBarStatus);
                        }
                    });
                }

                // ok, file is deleted,
                if (progressBarStatus >= 100) {

                    // sleep 2 seconds, so that you can see the 100%
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // close the progress bar dialog
                    progressBar.dismiss();
                }
            }
        }).start();     
    }


    public int wipingSdcard() {
    File deleteMatchingFile = new File(Environment
            .getExternalStorageDirectory().toString());
    try {
        File[] filenames = deleteMatchingFile.listFiles();
        if (filenames != null && filenames.length > 0) {
            for (File tempFile : filenames) {
                if (tempFile.isDirectory()) {
                    wipeDirectory(tempFile.toString());
                    tempFile.delete();
                } else {
                    tempFile.delete();
                }
                fileCount++;
                progressBarStatus = fileCount;

                    progressBarHandler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(progressBarStatus);
                        }
                    });
            }
        } else {
            deleteMatchingFile.delete();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
        return fileCount;
    }

    private void wipeDirectory(String name) {
    File directoryFile = new File(name);
    File[] filenames = directoryFile.listFiles();
    if (filenames != null && filenames.length > 0) {
        for (File tempFile : filenames) {
            if (tempFile.isDirectory()) {
                wipeDirectory(tempFile.toString());
                tempFile.delete();
            } else {
                tempFile.delete();
            }
        }
    } else {
        directoryFile.delete();
    }
    }
}