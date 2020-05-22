public class GetPolicyByDateRequest {

    private String date;
    private int toPage;
    private int fromPage;
    private Integer pageSize;
    private Integer id;

    public GetPolicyByDateRequest() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getToPage() {
        return toPage;
    }

    public void setToPage(int toPage) {
        this.toPage = toPage;
    }

    public int getFromPage() {
        return fromPage;
    }

    public void setFromPage(int fromPage) {
        this.fromPage = fromPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MyRequest{" +
                "date='" + date + '\'' +
                ", toPage=" + toPage +
                ", fromPage=" + fromPage +
                ", pageSize=" + pageSize +
                ", id=" + id +
                '}';
    }
}