public class DialogShow extends View {
SharedPreferences dialogPreferences;
String prefrencestring;
CheckBox nevershowagain;
Button closedialog;
Dialog dialog;
View view;

public DialogShow(final Context context) {
    super(context);
    dialog = new Dialog(context);
    view = View.inflate(context, R.layout.startdialog, null);
    dialog.setContentView(view);
    nevershowagain = (CheckBox) view.findViewById(R.id.nevershowagain);
    closedialog = (Button) view.findViewById(R.id.closedialog);

    closedialog.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {

            if (nevershowagain.isChecked()) {
                prefrencestring = "1";

                dialogPreferences = PreferenceManager
                        .getDefaultSharedPreferences(context);
                Editor editprefrences = dialogPreferences.edit();
                editprefrences.putString("showdialog", prefrencestring);
                editprefrences.commit();
            }

            dialog.dismiss();
        }
    });

    dialogPreferences = PreferenceManager
            .getDefaultSharedPreferences(context);
    String check = dialogPreferences.getString("showdialog", "");
    if (check.equals("1")) {
    } else {
        dialog.show();
    }
}