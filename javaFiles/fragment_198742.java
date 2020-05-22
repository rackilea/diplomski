private String adresUriSumy() {
    //Use Strings from the EditText fields:
    EditText liczbaAInput = (EditText) findViewById(R.id.A);
    String liczbaA = liczbaAInput.getText().toString();
    String liczbaAParam = String.format("liczbaA=%s", liczbaA);

    //Use liczbaB below:
    EditText liczbaBInput = (EditText) findViewById(R.id.B);
    String liczbaB = liczbaBInput.getText().toString();
    String liczbaBParam = String.format("liczbaB=%s", liczbaB);//modified

    String podstawowyAdres = "calculator://wwsis.com.pl/suma";

    //notice the & below
    String adres2 = String.format("%s?%s&%s", podstawowyAdres, liczbaAParam, liczbaBParam);

    return (adres2);
}