@Root(strict=false)
public class SearchInfosXten {

    @Element(name = "results")
    private Results results;

    public Results getResults() {
        return results;
    }
}

@Root(strict = false)
public class Results {

    @Element(name = "total_count")
    private int totalCount;

    @ElementList(entry = "result", inline = true)
    private List<Result> result;

    public int getTotalCount() {
        return totalCount;
    }

    public List<Result> getResult() {
        return result;
    }

}

@Root(strict = false)
public class Result {

    @Attribute(name = "type")
    private String type;

    @Attribute(name = "no")
    private int no;

    @Attribute(name = "docid")
    private int docId;

    @Attribute(name = "count")
    private int count;

    @ElementMap(entry = "field", key = "name", attribute = true, inline = true)
    private Map<String, String> fields;

    public String getType() {
        return type;
    }

    public int getNo() {
        return no;
    }

    public int getDocId() {
        return docId;
    }

    public int getCount() {
        return count;
    }

    public List<Item> getItems() {
        return items;
    }

    public Map<String, String> getFields() {
    return fields;
    }

}