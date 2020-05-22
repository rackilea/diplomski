private void wezDanezUri() {
    Uri uri = getIntent().getData();

    if (uri != null) {

        double liczbaA = getDoubleParam(uri, "liczbaA");
        double liczbaB = getDoubleParam(uri, "liczbaB");

        double suma = liczbaA + liczbaB;

        TextView textView = (TextView) findViewById(R.id.wyswietlacz);

        //modified:
        textView.setText(Double.toString(liczbaA) + " + " + Double.toString(liczbaB) + " = " + Double.toString(suma));

    }
}