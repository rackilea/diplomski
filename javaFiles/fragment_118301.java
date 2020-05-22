import com.google.gdata.data.docs.DocumentListEntry;
import com.google.gdata.data.docs.DocumentListFeed;

public class Example {

static public void main(String[] args) throws Exception {
    DocumentList docList = new DocumentList("document");
    docList.login("********@gmail.com", "********");
    DocumentListFeed feed = docList.getDocsListFeed("all");
    for (final DocumentListEntry entry : feed.getEntries()) {
       System.out.println(entry.getTitle().getPlainText());
    }
    }
}