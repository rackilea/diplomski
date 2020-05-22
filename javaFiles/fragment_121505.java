...
FillCombo(arrOwner , "Owners", "OwnerName");
EventList<String> ownerEventList = GlazedLists.eventList(arrOwner);
EventComboBoxModel<String> ownerModel = new EventComboBoxModel<String>(ownerEventList);
JComboBox comboOwner = new JComboBox(ownerModel);
AutoCompleteSupport<String> supOwner = AutoCompleteSupport.install(comboOwner,ownerEventList);
supOwner.setStrict(true);
...