try {
    Double pocetKm = Double.parseDouble(editText_pocetKM.getText().toString());
    Double spotreba = Double.parseDouble(editText_spotreba.getText().toString());
    Double cenaPHM = Double.parseDouble(editText_cenaPHM.getText().toString());
} catch (Exception e) {
    e.printStackTrace();
    Toast.makeText(this, "Parsing error", Toast.LENGTH_LONG).show();
}