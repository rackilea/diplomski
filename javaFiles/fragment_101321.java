public abstract class EnumService {
    abstract <T extends Enum<T> & ServiceArgument> void query (T e);
}

public class ServiceTranslation extends EnumService implements Serializable {
    @Override
    <T extends Enum<T> & ServiceArgument> void query (T e) {
       if (e.ordinal() >= e.size()) {
            throw InvalidStringCodeAsked();
       }
    }
}