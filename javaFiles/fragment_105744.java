public class PrepaidBase extends Activity {

AlertDialog.Builder builder;

private String number = "";
private String packageName;
private String price;
private String title;

public PrepaidBase()
{}

public void setPackageInformation(String name, String price, String number, String title)
{
    this.number = number;
    this.packageName = name;
    this.price = price;
    this.title = title;
}

public void activatePackage()
{

    try
    {

        new AlertDialog.Builder(PrepaidBase.this)
                .setTitle(PrepaidBase.this.title)
                .setMessage("Are you sure you want to activate " + PrepaidBase.this.packageName + " in RS: " + PrepaidBase.this.price)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent in = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + Uri.encode(PrepaidBase.this.number)));
                        startActivity(in);
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                       dialog.cancel();
                    }
                })
                //.setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }catch (ActivityNotFoundException e)
    {
        e.printStackTrace();
    }
}