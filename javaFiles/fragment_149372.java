public class Records {

    public interface RecordFetcher<T>{
        public List<T> getRecords();
    }
    static RecordFetcher<Fruit> Fruit=new RecordFetcher<Fruit>(){
        public List<Fruit> getRecords() {
            ...
        }
    };


    static RecordFetcher<User> User=new RecordFetcher<User>(){
        public List<User> getRecords() {
            ...
        }   
    };

    public static void main(String[] args) {
        List<Fruit> fruitRecords=Records.Fruit.getRecords();
        List<User> userRecords=Records.User.getRecords();

    }
}