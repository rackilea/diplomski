package tikatest01;

import java.io.File;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.SimpleFSDirectory;
import org.apache.lucene.util.Version;
import org.apache.tika.Tika;

public class TikaTest01 {

    public static void main(String[] args) throws Exception {

        String dirname = "C:\\MyTestDir\\";
        File dir = new File(dirname);


        IndexWriter writer = new IndexWriter(
            new SimpleFSDirectory(dir), 
            new IndexWriterConfig(
                Version.LUCENE_47, 
                new StandardAnalyzer(Version.LUCENE_47)));
        try {
            LuceneIndexer indexer = new LuceneIndexer(new Tika(), writer);
            indexer.indexDocument(dir);
            } 
        finally {
            writer.close();
            }
    }
}