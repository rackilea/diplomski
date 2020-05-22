public class PartAction extends ActionSupport {

  public class SearchResult {
    private String col1;
    private String col2;

    public String getCol1() {
      return col1;
    }

    public void setCol1(String col1) {
      this.col1 = col1;
    }

    public String getCol2() {
      return col2;
    }

    public void setCol2(String col2) {
      this.col2 = col2;
    }

    public SearchResult(String col1, String col2) {
      this.col1 = col1;
      this.col2 = col2;
    }
  }

  private InputStream stream;

  //getter here
  public InputStream getStream() {
    return stream;
  }

  private List<SearchResult> findList = new ArrayList<>();

  public List<SearchResult> getFindList() {
    return findList;
  }

  public void setFindList(List<SearchResult> findList) {
    this.findList = findList;
  }

  private String list() {
    JSONObject jo = new JSONObject();
    try {
      for (SearchResult part : findList) {
        jo.put("col1", part.getCol1());
        jo.put("col2", part.getCol2());
      }
      System.out.println("--------->:"+jo.toString());
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println(e.getMessage());
    }
    return jo.toString();
  }

  @Action(value="part", results = {
    @Result(name="stream", type="stream", params = {"contentType", "text/html", "inputName", "stream"}),
    @Result(name="stream2", type="stream", params = {"contentType", "application/json", "inputName", "stream"}),
    @Result(name="json", type="json", params={"root", "findList"})
  })
  public String finder() {
    findList.add(new SearchResult("val1", "val2"));
    stream = new ByteArrayInputStream(list().getBytes());
    return "stream2";
  }
}