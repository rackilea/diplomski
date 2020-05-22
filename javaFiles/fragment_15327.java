AmbilWarnaDialog dialog = new AmbilWarnaDialog(getActivity().getApplicationContext(), 0xff0000ff, new OnAmbilWarnaListener() {

    // Executes, when user click Cancel button
    @Override
    public void onCancel(AmbilWarnaDialog dialog){
    }

    // Executes, when user click OK button
    @Override
    public void onOk(AmbilWarnaDialog dialog, int color) {
        Toast.makeText(getBaseContext(), "Selected Color : " + color, Toast.LENGTH_LONG).show();
    }
});