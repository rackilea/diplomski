class GameView extends View {

    private Context mContext;

    //Constructor
    public GameView (Context context) {
        super(context);
        mContext = context
    }

    //Can be called inside the view
    public ShowDialog() {
        AlertDialog alertDialog = new AlertDialog.Builder(mContext).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage("Alert message to be shown");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
            new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
        });
        alertDialog.show();
    }
}