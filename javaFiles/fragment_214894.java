import android.os.Handler;

private final Handler handler;


...
handler = new Handler();
...
@Override
 public void afterTextChanged(Editable editable) {
    handler.removeCallbacksAndMessages(null);
    Runnable runnable = new Runnable(){
        void run(){
             writeToFileExt(textResult.getText().toString());
             setButtonLabel(R.id.buttonReadAudio, "Read Audio");
             addItemsOnSpinnerModels();
             cancel();
      }
    };
    handler.postDelayed(runnable,25000);
 }
...