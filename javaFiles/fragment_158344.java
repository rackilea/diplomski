public class ListWrapper {    
    private final List<String> obj;     
    public ListWrapper (Object obj) { 
        this.obj = obj; 
    }     

    public List<String> getList() { 
        return obj; 
    } 
}