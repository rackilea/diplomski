if (e.getSource() == jButton1) {
    //Do Something
} else {

    JComboBox cb = (JComboBox)e.getSource();
    String petName = (String)cb.getSelectedItem();

    if(petName == "Cat") {
        //Do Something
    }
}