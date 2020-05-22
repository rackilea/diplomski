private List<Group> groupTypes;
DatabaseApp db = new DatabaseApp();
groupTypes = db.getGroups();
groupDropDownChoice = new DropDownChoice("type", groupTypes, new IChoiceRenderer(){
    @Override
    public Object getDisplayValue(Object object) {
        return ((Group) object).getName();
    }

    @Override
    public String getIdValue(Object object, int index) {
        return Integer.toString(index);
    }
});
...
...
addUserForm.add(new Button("submit"){
            @Override
            public void onSubmit(){
                Group group = (Group) groupDropDownChoice.getModelObject(); 
...
...
            db.addUser(group.getId(), den, name, login, email, password1);