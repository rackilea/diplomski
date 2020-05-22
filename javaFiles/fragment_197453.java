import org.apache.solr.client.solrj.beans.Field;

public class SampleDocument {

    public SampleDocument() {
        // required for solrj to make an instance
    }

    public SampleDocument(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Field("title")
    public void setTitle(String title) {
        this.title = title;
    }

}