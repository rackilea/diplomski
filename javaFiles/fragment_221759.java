addToArrayListOfPeople(6);

listMod = new DefaultListModel<SamplePerson>();
for (SamplePerson person : arrayListOfPeople) {
    listMod.addElement(person);
}