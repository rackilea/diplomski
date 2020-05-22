public class DataHistoryListener {
   @PrePersist
    public void setCreateDataHistory(DataHistoryAware model) {
        //set creationDate
        DataHistory dataHistory = model.getDataHistory() == null ? new DataHistory() : model.getDataHistory();
        dataHistory.setCreationDate(new Date());
        model.setDataHistory(dataHistory); 
    }
@PostUpdate
    public void setUpdateDataHistory(DataHistoryAware model) {
        DataHistory dataHistory = model.getDataHistory() == null ? new DataHistory() : model.getDataHistory();
        dataHistory.setLastModificationDate(new Date());
        model.setDataHistory(dataHistory);
    }
}