public class BaseResponse<T> {

    private T data;
    private int status;
    private String message;

    public T getData(){
        return this.data;
    }

    public int getStatus(){
        return this.status;
    }

    public String getMessage(){
        return this.message;
    }
}