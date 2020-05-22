public List<Trigger> getTriggerList() {
        this.get();
        return triggerList;
    }

private void get() {
    DataTable dataTable = (DataTable) FacesContext.getCurrentInstance()
            .getViewRoot().findComponent("form:jobs");
    JobDetail jb = (JobDetail) dataTable.getRowData();
    this.triggerList = this.jobServiceImpl.getAllTriggers(scheduler,
            jb.getKey());

}