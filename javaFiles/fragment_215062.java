@SuppressLint("NewApi") 
        public static AlertDialog displayMessage(Context context, String title, String message, final MyMessageDialogListener listener){ 
            AlertDialog.Builder builder = new AlertDialog.Builder(context); 
            LayoutInflater inflater = LayoutInflater.from(context);
            builder.setTitle(title); 
            builder.setMessage(message); 
            final View layoutView = inflater.inflate(R.layout.custom_view, null);
            builder.setView(layoutView);
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() { 
            @Override 
            public void onClick(DialogInterface dialog, int which) { 
                boolean entriesValid = true;
                // get the edit text values here and pass them back via the listener
               try
                {
                EditText shipText = (EditText)layoutView.findViewById(R.id.shipNameEditText);
                EditText scientistNameText = (EditText)layoutView.findViewById(R.id.scientistEditText);
                EditText scientistEmailText = (EditText)layoutView.findViewById(R.id.emailEditText);
                EditText volumeText = (EditText)layoutView.findViewById(R.id.volumeEditText);
                EditText colourText = (EditText)layoutView.findViewById(R.id.colourEditText);

                String strShipName = shipText.getText().toString();
                String strScientistName = scientistNameText.getText().toString();
                String strScientistEmail = scientistEmailText.getText().toString();
                String strVolume = volumeText.getText().toString();
                String strColour = colourText.getText().toString();

                if(TextUtils.isEmpty(strShipName)) {
                    shipText.setError("Please enter a value");
                    entriesValid = false;
                 }
                else if(TextUtils.isEmpty(strShipName)) {
                    shipText.setError("Please enter a value");
                    entriesValid = false;
                 }
                else if(TextUtils.isEmpty(strScientistName)) {
                    scientistNameText.setError("Please enter a value");
                    entriesValid = false;
                 }
                else if(TextUtils.isEmpty(strScientistEmail)) {
                    scientistEmailText.setError("Please enter a value");
                    entriesValid = false;
                 }
                else if(TextUtils.isEmpty(strVolume)) {
                    volumeText.setError("Please enter a value");
                    entriesValid = false;
                 }
                else if(TextUtils.isEmpty(strColour)) {
                    colourText.setError("Please enter a value");
                    entriesValid = false;
                 }
                }
    catch(Exception e)
    {
    entriesValid = false;
    }
                if(entriesValid)
                    dialog.dismiss(); 
                } 
                }); 
                builder.show(); 
                return builder.create();
            }