String[] arrayFromXML;

public void questionGenerator() {
    Random gen = new Random();
    int value = gen.nextInt(4);

    arrayFromXML = getResources().getStringArray(R.array.arrayFromXML);

    xmlText.setText(arrayFromXML[value]);
}