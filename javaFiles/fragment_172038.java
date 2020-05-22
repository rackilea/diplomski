final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.custom);
        dialog.setTitle("Title...");

        Button dialogButton = (Button)dialog.findViewById(R.id.dialogButtonOK);
        Typeface standardFont = Typeface.MONOSPACE;
        dialogButton.setTypeface(standardFont)

        // if button is clicked, close the custom dialog
        dialogButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });