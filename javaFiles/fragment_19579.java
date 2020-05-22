if (testString.equals("ok")) {
        CompoBox.removeAllItems();
        for (int i = 0; i < array.length; i++) {
            String sample = array[i];
            CompoBox.addItem(sample + "aa");
        }
    }