public interface MyDataConverter {
    MyData convertData(MyData data);
}

public class MyDataConverterImplementation implements MyDataConverter {
    public MyData convertData(MyData data) {
        // Some complex logic...
        return data;
    }
}