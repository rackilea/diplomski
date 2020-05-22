ArrayList<String> titlesArr = new ArrayList<String>(filmListe.size());

    for (JCheckBox checkbox : filmListe) {
        if (checkbox.isSelected()) {
            titlesArr.add(checkbox.getText());
        }
    }