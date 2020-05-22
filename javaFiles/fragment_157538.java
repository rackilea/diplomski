import org.rekdev.List;
import java.util.List;

public class ListStack< E > implements Stack< E > {
    private List< E > stack; 
    private List<E> myOwnList;
}

ListStack.java:2: org.rekdev.List is already defined in a single-type import
import java.util.List;
^
1 error