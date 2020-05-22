import java.util.LinkedList;
import java.util.List;

public class Test1 {

    static List<Object> getList(){
        return new LinkedList<Object>();
    }

    void process(Object o) {}

    void foo1(){
        for(Object o: getList()){
            process(o);
        }
    }

    void foo2(){
        List<Object>  os = getList();
        for(Object o: os){
            process(o);
        }
    }
}