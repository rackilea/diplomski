//Just take your existing anonymous subclass definitions and put them here
private DialogInterface.OnClickListener listener1 = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            };
private DialogInterface.OnClickListener listener2 = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            }

public Dialog onCreateDialog(Bundle savedInstanceState) {
    final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    builder.setTitle("MyTitle")
            .setMessage("MyMessage")
            .setPositiveButton("OK", listener1)
            .setNegativeButton("Cancel", listener2);
    return builder.create();
}

// Call these methods from outside this class
public void onClick1(){
    listener1.onClick();
}

public void onClick2(){
    listener2.onClick();
}