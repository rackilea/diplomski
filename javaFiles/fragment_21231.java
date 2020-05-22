boolean matchNotFound = registry.getSuspectList()
        .stream()
        .filter(s -> s.getName().equals(textField.getText()))
        .noneMatch();

if (matchNotFound) {
    JOptionPane.showMessageDialog(null,"Suspect " + textField.getText() + " not found!");
}