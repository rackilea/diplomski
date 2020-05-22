int rows = prefStore.getInt("rowCount");

for (int row = 0; row < rows; ++row) {
    String nameKey = "name" + row;
    String bcKey = "bc" + row;
    String fcKey = "fc" + row;

    String name = prefStore.getString(nameKey);
    RGB bc = StringConverter.asRGB(prefStore.getString(bcKey));
    RGB fc = StringConverter.asRGB(prefStore.getString(fcKey));

    ...
}