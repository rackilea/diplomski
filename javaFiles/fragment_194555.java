Button dialogButton = dialog.findViewById(R.id.dialog_button_OK);
        // if button is clicked, close the custom dialog

        dialogButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                setButtonPress(v, event);
                return false;

            }
        });

        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();