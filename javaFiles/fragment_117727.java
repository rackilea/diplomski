public interface Buildable {

    public ContentValues values();

}

public interface Builder<S, T extends Buildable> {

    public T build(S source);

}

public class Module implements Buildable {

    @Override
    public ContentValues values() {
        ContentValues c = new ContentValues();
        c.put("name", getClass().getName());
        return c;
    }

}

public class ModuleFromCursorBuilder implements Builder<Cursor, Module> {

    @Override
    public Module build(Cursor source) {
        return new Module();
    }

}

public class QuizFromCursorBuilder implements Builder<Cursor, Quiz> {

    @Override
    public Quiz build(Cursor source) {
        return new Quiz();
    }

}

Cursor cursor = null;
Log.i("ModuleFromCursorBuilder",new ModuleFromCursorBuilder().build(cursor).values().get("name")+"");
Log.i("QuizFromCursorBuilder",new QuizFromCursorBuilder().build(cursor).values().get("name")+"");