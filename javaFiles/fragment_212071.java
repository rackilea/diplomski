import java.util.List;

import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.record.impl.ODocument;
import com.orientechnologies.orient.core.sql.query.OSQLSynchQuery;

public class DBTESTER {

    public static void main(String[] args) {
        // OPEN THE DATABASE

        // ODatabaseDocumentTx db = new ODatabaseDocumentTx
        // ("local:D:/OrientDB/orientdb-community-1.7-rc1/orientdb-community-1.7-rc1/databases/petshop").create();
        ODatabaseDocumentTx db = new ODatabaseDocumentTx(
                "local:D:/OrientDB/orientdb-community-1.7-rc1/orientdb-community-1.7-rc1/databases/petshop")
                .open("admin", "admin");

        // CREATE A NEW DOCUMENT AND FILL IT
        for (int i = 0; i < 10; i++) {
            ODocument doc = new ODocument("foryou");
            doc.field("number", i);
            doc.save();
        }
        List<ODocument> result = db.query(new OSQLSynchQuery<ODocument>(
                "select * from foryou"));

        System.out.println("No of ODocuments:\t" + result.size());

        for (ODocument od : result) {
            System.out.println(od.field("number")+"\t");

        }

    }

}