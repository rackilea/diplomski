...
Phonebook l_Phonebook = Phonebook.getInstance();
l_Phonebook.addPhoneNumber("Yoschi", "01774448882")
... 
// somewhere else
Phonebook l_Phonebook = Phonebook.getInstance();
Phone.getInstance().call(l_Phonebook.getPhoneNumber("Yoschi"));