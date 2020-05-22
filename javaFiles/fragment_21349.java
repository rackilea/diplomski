public class MyAlertDialog // See change is here
{
    public Dialog onCreateDialog(Bundle savedInstanceState) 
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Time: " + SMSReceiver.getTime() + "\nIncident: " + 
                SMSReceiver.getCallType() + "\nLocation: " + SMSReceiver.getAddress())
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {


                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {


                    }
                });

        return builder.create();

    }
}