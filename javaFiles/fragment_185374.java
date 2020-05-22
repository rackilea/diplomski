class MyDataType<T extends Comparable<T>>{
    T data;

    public MyDataType(T _data){
        data = _data;
    }
}