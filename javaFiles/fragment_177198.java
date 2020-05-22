class NewArrayList extends ArrayList {

}

abstract class MyService<T> {
    public abstract T createObject();

    public void run() {
        T t = createObject();
        //work with the object
    }
}

class CustomService extends MyService<NewArrayList> {
    @Override
    public NewArrayList createObject() {
        return new NewArrayList();
    }
}