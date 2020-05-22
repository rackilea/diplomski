int row = 0;
for (TableItem item : this.viewer.getTable().getItems()) {
    Content c = (Content) item.getData();
    String name = c.getName();
    RGB bc = c.getBackgroundColor();
    RGB fc = c.getForegroundColor();

    String nameKey = "name" + row;
    String bcKey = "bc" + row;
    String fcKey = "fc" + row;

    prefStore.setValue(nameKey, name);
    prefStore.setValue(bcKey, StringConverter.asString(bc));
    prefStore.setValue(fcKey, StringConverter.asString(fc));

    ++row;
}

prefStore.setValue("rowCount", row);