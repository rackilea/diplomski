import org.rekdev.*;

public class ListStack< E > implements Stack< E > {
    // This kid is java.util.List
    private java.util.List< E > stack; 
    // This kid is org.rekdev.List
    private List<E> myOwnList;