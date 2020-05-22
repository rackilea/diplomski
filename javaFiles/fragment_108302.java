public void ButtonKlick (View view) {

 switch (view.getId())
{
    case (R.id.button1Id):
    // do specific stuff for button with id button1Id like
    Ergebnis = Math.sqrt(Math.pow(zahl4 - zahl3, 2) + Math.pow(zahl2 - zahl1, 2));
    break;
    case (R.id.button2Id):
     Ergebnis = (zahl4 - zahl3) / (zahl2 - zahl1);
     break;
     ...
}
double zahl1;
double zahl2;
double zahl3;
double zahl4;
double Ergebnis = 0;
EditText Feld1 = (EditText)findViewById(R.id.zahl1);
EditText Feld2 = (EditText)findViewById(R.id.zahl2);
EditText Feld3 = (EditText)findViewById(R.id.zahl3);
EditText Feld4 = (EditText)findViewById(R.id.zahl4);
EditText FeldErgebnis = (EditText)findViewById(R.id.etErgebnis);
if (Feld1.getText().toString().length() == 0 ) {
    return;
}
if (Feld2.getText().toString().length() == 0 ) {
    return;
}
if (Feld3.getText().toString().length() == 0 ) {
    return;
}
if (Feld4.getText().toString().length() == 0 ) {
    return;
}
zahl1 = Double.parseDouble(Feld1.getText().toString());
zahl2 = Double.parseDouble(Feld2.getText().toString());
zahl3 = Double.parseDouble(Feld3.getText().toString());
zahl4 = Double.parseDouble(Feld4.getText().toString()); 


Ergebnis = Math.sqrt(Math.pow(zahl4 - zahl3, 2) + Math.pow(zahl2 - zahl1, 2));

FeldErgebnis.setText(String.valueOf(Ergebnis));