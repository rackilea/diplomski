import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.store.RAMDirectory;

import java.io.IOException;

class Blacklist {

    private static final String MATCH_ALL = "*";
    private static IndexSearcher cache;

    private enum Fields {
        REFERRER, IP, USER_AGENT, EMAIL
    }

    private static Document getDocument(String referrer, String ip, String userAgent, String email) {
        Document doc = new Document();
        doc.add(getStringField(referrer, Fields.REFERRER.name()));
        doc.add(getStringField(ip, Fields.IP.name()));
        doc.add(getStringField(userAgent, Fields.USER_AGENT.name()));
        doc.add(getStringField(email, Fields.EMAIL.name()));
        return doc;
    }

    private static StringField getStringField(String val, String field) {
        return new StringField(field, val, Field.Store.NO);
    }

    private static BooleanQuery createQuery(String referrer, String ip, String userAgent, String email) {
        return new BooleanQuery.Builder()
                .add(createBooleanQuery(Fields.REFERRER.name(), referrer), BooleanClause.Occur.FILTER)
                .add(createBooleanQuery(Fields.IP.name(), ip), BooleanClause.Occur.FILTER)
                .add(createBooleanQuery(Fields.USER_AGENT.name(), userAgent), BooleanClause.Occur.FILTER)
                .add(createBooleanQuery(Fields.EMAIL.name(), email), BooleanClause.Occur.FILTER)
                .build();
    }

    private static BooleanQuery createBooleanQuery(String key, String value) {
        return new BooleanQuery.Builder()
                .add(new TermQuery(new Term(key, value)), BooleanClause.Occur.SHOULD)
                .add(new TermQuery(new Term(key, MATCH_ALL)), BooleanClause.Occur.SHOULD)
                .build();
    }

    private static boolean isBlacklisted(String ref, String ip, String ue, String email) throws IOException {
        BooleanQuery query = createQuery(ref, ip, ue, email);
        return cache.search(query, 1).totalHits > 0;
    }


    public static void main(String[] args) throws IOException {
        RAMDirectory directory = new RAMDirectory();
        IndexWriter writer = new IndexWriter(directory, new IndexWriterConfig(new StandardAnalyzer()));
        writer.addDocument(getDocument("ref1", "127.0.0.ip1", "Mozilla UserAgent1", "email.com"));
        writer.addDocument(getDocument("ref2", "127.0.0.ip2", "Mozilla UserAgent2", "*"));
        writer.close();
        DirectoryReader reader = DirectoryReader.open(directory);
        cache = new IndexSearcher(reader);

        System.out.println(isBlacklisted("ref1", "127.0.0.ip1", "Mozilla UserAgent1", "email.com"));
        System.out.println(isBlacklisted("r2.com", "127.0.0.4", "Mozilla", "yahoo.com"));
        System.out.println(isBlacklisted("ref2", "127.0.0.ip2", "Mozilla UserAgent2", "this is ignored"));
        System.out.println(isBlacklisted("*", "127.0.0.ip2", "Mozilla UserAgent2", "*"));
    }
}