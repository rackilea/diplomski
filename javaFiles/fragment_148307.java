//load the list of objects to use
ContainerClass[] allOptions = ContainerClass.getAll();

//create an EventList with this list and set is as the combobox model
final EventList<ContainerClass> eventList = GlazedLists.eventList(Arrays.asList(allOptions));
comboBox.setModel(new DefaultComboBoxModel<ContainerClass>(allOptions));

//finally initialize the combobox by SwingUtilities if done on a non-UI thread
SwingUtilities.invokeLater(new Runnable() {
    @Override
    public void run() {
        AutoCompleteSupport<ContainerClass> install = 
                AutoCompleteSupport.install(comboBox, eventList);
        install.setFilterMode(TextMatcherEditor.CONTAINS);
        install.setHidesPopupOnFocusLost(true);
        install.setSelectsTextOnFocusGain(false);
        install.setCorrectsCase(false);
    }
});