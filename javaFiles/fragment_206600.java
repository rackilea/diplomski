dialog.setButton(DialogInterface.BUTTON_POSITIVE, "Convert", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DisplayCalculationActivity.this.startActivity(i);
            }
        }
);