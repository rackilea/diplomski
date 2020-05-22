public class Task {
    private String title;
    private String description;
    private Date endDate;

    public Task(String title, String description, Date endDate) {
        this.title = title;
        if(description != null) {
            this.description = description;
        }
        if(endDate != null) {
            this.endDate = endDate;
        }
    }
}