public interface OnDialogClickListener {
    void onDialogImageRunClick();
}

public class CustomTypeDialog extends Dialog {
    private final OnDialogClickListener listener;
    public CustomTypeDialog(final Context context, OnDialogClickListener listener) {
          this.listener = listener;
    }

     ....
     imageRun.setOnClickListener(new View.OnClickListener() {    
            @Override
            public void onClick(View v) {
                  listener.onDialogImageRunClick();
            }
    );
}