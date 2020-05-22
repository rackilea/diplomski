public class IdResult{

    private Object id;

    public IdResult(Object id){
        this.id = id;
    }

     public Long getLongId(){
        return (Long)id;
     }
}