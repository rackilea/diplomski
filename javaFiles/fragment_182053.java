public void onClick (DialogInterface dialog, int which) {
    if (DialogInterface.BUTTON_POSITIVE == which) {
        RadioButton button = (RadioButton) ((AlertDialog) dialog).findViewById(R.id.radio_button_id);
        // continue using button
    }
}