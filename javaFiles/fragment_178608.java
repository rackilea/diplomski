package tikatest01;

import java.io.File;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.tika.Tika;

public class LuceneIndexer {

    private final Tika tika;
    private final IndexWriter writer;

    public LuceneIndexer(Tika tika, IndexWriter writer) {
        this.tika = tika;
        this.writer = writer;
    }

    public void indexDocument(File file) throws Exception {
        Document document = new Document();
        document.add(new TextField(
                "filename", file.getName(), Store.YES));
        document.add(new TextField(
                "fulltext", tika.parseToString(file), Store.NO));
        writer.addDocument(document);
    }
}