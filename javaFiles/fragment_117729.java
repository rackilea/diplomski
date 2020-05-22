public interface Valuable {

    public ContentValues values();

}

public class Question implements Valuable {

    @Override
    public ContentValues values() {
        return new ContentValues();
    }

}

public class Page implements Valuable {

    @Override
    public ContentValues values() {
        return new ContentValues();
    }

}