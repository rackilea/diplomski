// in this example, AddPet is a modal JDialog, not a JFrame
protected void openAdd() {
    // I'm passing *this* into the constructor, so it can be used ...
    //    ... in the JDialog super constructor
    AddPet add = new AddPet(this, ADD_PROMPT, FIELDS, DATE_PROMPT);
    add.setVisible(true);

    // code starts here immediately after the AddPet modal dialog is no longer visible
    // so you can extract information from the class easy:

    String petName = add.getPetName(); // I know you don't use these exact methods
    String petBreed = add.getPetBreed(); // but they're just a "for instance" type of code
    // ... etc

}