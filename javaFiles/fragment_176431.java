final ComboBox comboBox = new ComboBox();
comboBox.addItem("");
comboBox.setNullSelectionItemId(comboBox.getItem(""));

comboBox.addItem("First item");
comboBox.addItem("Second item");
comboBox.setNullSelectionAllowed(true);
comboBox.setInputPrompt("Select an item:");
comboBox.select("First item");

comboBox.addListener(new BlurListener() {

@Override
public void blur(final BlurEvent event) {
        comboBox.setValue("");
    }
});