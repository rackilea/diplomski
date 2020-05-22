package de.leonso.test;
import lotus.domino.Database;
import lotus.domino.Document;
import lotus.domino.NotesException;
import com.ibm.xsp.model.domino.DominoUtils;

public class Crasher {
    public static void crash() throws NotesException {
        Database database = DominoUtils.getCurrentDatabase();
        for (long docNumber = 1; docNumber <= 100000; docNumber++) {
            Document doc = database.createDocument();
            doc.replaceItemValue("Number", Long.valueOf(docNumber));
            for (int itemNumber = 3; itemNumber <= 1000; itemNumber++) {
                doc.replaceItemValue("Item" + itemNumber, itemNumber);
            }
            System.out.println(docNumber);
            doc.save();
        }
    }
}