public class MyResponse<T> implements Serializable{
    private boolean status ;
    private String message ;
    private DataType dataType ;
    private T data;


    public DataType getDataType() {
        return dataType;
    }

    //... other getters and setters
}