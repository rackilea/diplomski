public void onRowUnselect(UnselectEvent unselectEvent){
    Employee emp = (Employee)unselectEvent.getObject();

    for (Employee e : employeeList) {
        if (emp.getId().equals(e.getId())) {
            e.setDisabled(true);
            e.setRemarks(e.getOldRemarks());
        }
    }
}