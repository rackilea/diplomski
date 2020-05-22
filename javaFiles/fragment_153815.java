TextColumn<User> departmentsColumn = new TextColumn<User>() {

    @Override
    public String getValue(User object) {
        StringBuilder departments = new StringBuilder();
        for(int i=0; i < object.getDepartments().size(); i++) {
            if (i>0) {
              departments.append(",");
            }
            departments.append(object.getDepartments().get(i).getDepartmentName());
        }
        return departments.toString();
    }
};