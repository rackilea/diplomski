public class QueryResult<T> {
    @JsonView(View.Summary.class)
    private int pageNumber;
    @JsonView(View.Summary.class)
    private int totalRecords;
    @JsonView(View.Summary.class)
    private int pageSize;
    @JsonView(View.SummaryWithRecipients.class)
    private List<T> entityList = new ArrayList<T>();
    //Here is getters & setters
}