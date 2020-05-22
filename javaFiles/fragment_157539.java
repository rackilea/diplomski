import org.rekdev.*;
import java.util.*;

public class ListStack< E > implements Stack< E > {
    private List< E > stack; 
    private List<E> myOwnList;
}

ListStack.java:5: reference to List is ambiguous, both class java.util.List in java.util and class org.rekdev.List in org.rekdev match
    private List< E > stack; 
            ^
ListStack.java:6: reference to List is ambiguous, both class java.util.List in java.util and class org.rekdev.List in org.rekdev match
    private List<E> myOwnList;
            ^
2 errors