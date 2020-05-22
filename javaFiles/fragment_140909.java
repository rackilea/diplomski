private void saveCoinsToPreferences() {
    SharedPreferences data = getSharedPreferences("MySavedData", Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = data.edit();
    editor.putInt("BALANCE", myBalance);
    editor.commit();
    Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show();
}