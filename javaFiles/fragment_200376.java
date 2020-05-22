runOnUiThread(new Runnable() {

    @Override
    public void run() {
        EditText eResult = (EditText)findViewById(R.id.lblResult);
        eResult.setText(sMsg); // Note that 'sMsg' as to be made 'final' to be used this way
    }
}