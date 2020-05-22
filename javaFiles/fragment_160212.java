EntityModel<Account> accModel = new EntityModel<Account>(Account.class, id);

add(new CheckBox("cb", new PropertyModel<Boolean>(accModel, "enabled")){
    protected boolean wantOnSelectionChangedNotifications() {
        return true;
    }
});