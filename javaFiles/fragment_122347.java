public class DatabaseHelper extends SQLiteOpenHelper {
    //...

    public void addNewThingyAsync(final String name, final Callback<Long> cb) {
        new Thread(new Runnable(){
            @Override
            public void run(){
                cb.callback(addNewThingy(name));
            }
        }).start();
    }

    private synchronized long addNewThingy(String name){
        //implementation...
    }

    public void getThingyByIdAsync(final long id, final Callback<Thingy> cb) {
        new Thread(new Runnable(){
            @Override
            public void run(){
                cb.callback(getThingyById(id));
            }
        }).start();
    }

    private synchronized Thingy getThingyById(long id) {
        //implementation...
    }

    public interface Callback<T> {
        public void callback(T t);
    }
}