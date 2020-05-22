import org.eclipse.persistence.descriptors.ClassExtractor;
import org.eclipse.persistence.sessions.*;

public class AnimalExtractor extends ClassExtractor {

    @Override
    public Class extractClassFromRow(Record record, Session session) {
        if(null != record.get("@wingSpan") || null != record.get("@preferredFood")) {
            return Bird.class;
        } else if(null != record.get("@favoriteToy")) {
            return Cat.class;
        } else {
            return Dog.class;
        }
    }

}