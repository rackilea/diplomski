// Create a handler
Handler handler = new Handler();
AlertDialog.Builder adb = new AlertDialog.Builder(this);
    LayoutInflater adbInflater = LayoutInflater.from(this);
    View eulaLayout = adbInflater.inflate(R.layout.checkbox, null);
    dontShowAgain = (CheckBox) eulaLayout.findViewById(R.id.skip);
    adb.setView(eulaLayout);
    adb.setTitle("Info");
    adb.setMessage(Html.fromHtml("Readme"));

    adb.setPositiveButton("Ok", new DialogInterface.OnClickListener() 
    {
            public void onClick(DialogInterface dialog, int which) 
            {
                String checkBoxResult = "NOT checked";
                if (dontShowAgain.isChecked())
                    checkBoxResult = "checked";

                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putString("skipMessage", checkBoxResult);
                editor.commit();
                return;
            }
        });

    SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
    String skipMessage = settings.getString("skipMessage", "NOT checked");

    if (!skipMessage.equals("checked"))
        AlertDialog dialog = adb.create();
        dialog.show();

    final Button button;
    button = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
    if(dialog.isShowing()){

        button.setClickable(false);
    }

    // Post the task to set it clickable in 10000ms
    handler.postDelayed(new Runnable(){
        @Override
        public void run() {
            //if(null !== button || button !== null)
                button.setClickable(true);
        }}, 10000);