public interface Buildable<T> {
    public T build(Cursor c);
}

public class ModuleBuilder implements Buildable<Module>{

    @Override
    public Module build(Cursor c) {
        return new Module();
    }

}

public class QuizBuilder implements Buildable<Quiz>{

    @Override
    public Quiz build(Cursor c) {
         return new Quiz();
    }

}