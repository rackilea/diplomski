private Map<Application, JTextField> nouvellesNaturesFields = new ArrayListMultimap<Application, JTextField>(); //Or Hashmap, if the key is unique
private Map<Application, JTextField> versionActuelleFields = new ArrayListMultiMap<Application, JTextField>();

public List<JTextField> getNouvellesNaturesFields() {
    return nouvellesNaturesFields ;
}

public List<JTextField> getVersionActuelleFields () {
    return versionActuelleFields ;
}    
//class code

for (Application app : model.getCheckedApplications()) {
    //Other code
    JTextField nouvellesNaturesField = new JTextField(
            30);
    nouvellesNaturesField.setName("nouvellesNatures"
            + app.getCode88());
    nouvellesNaturesFields.put(app, nouvellesNaturesField);

    //Other code and same for your new nature fields
}
result = JOptionPane.showConfirmDialog(null, myPanel,
        "Valeurs de cette version",
        JOptionPane.OK_CANCEL_OPTION);