public class MyClass {
    private DbConnection dbCon;
    private MyDataConverter converter;

    public MyClass(DbConnection dbCon, MyDataConverter converter) {
        this.dbCon = dbCon;
        this.converter = converter;
    }

    public void doSomethingWith(MyData data) {
        data = converter.convertData(data);
        dbCon.storeData(data);
    }
}