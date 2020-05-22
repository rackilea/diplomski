public class RecordService {
    public RecordService() {
    }
    //since it has no real business logic, it will serve as facade
    public String[] getRecords() {
        AddRecords addRecords = new AddRecords();
        return addRecords.populateSelect();
    }
}