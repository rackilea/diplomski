public class AlertUtils {

    public interface Listener {
      void onButtonClicked(int pressedButton);
    }

    private Listener mListener;

    private AlertDialog.Builder builder;

    public AlertUtils(Context context, Listener listener){
        builder = new AlertDialog.Builder(context);
        mListener = listener;
    }

    public void ShowAlertWithTwoButtons(String Title,String Message,String PositiveButtonText,
                                        String NegativeButtonText){
        ...

        builder.setPositiveButton(PositiveButtonText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mListener.onButtonClicked(i);
            }
        });

        builder.setNegativeButton(NegativeButtonText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mListener.onButtonClicked(i);
                dialogInterface.dismiss();
            }
        });

        builder.show();
    }
}