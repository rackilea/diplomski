public interface Keyable <T> {public String getKey();}

public interface DataElement<THIS extends DataElement<THIS>> extends Comparable<Keyable<THIS>>, Keyable<THIS>, Serializable {...}
public class Course implements DataElement<Course> {...}


public interface SearchTree<K extends Comparable<Keyable<K>> & Keyable<K>> extends Serializable {...}
public class MySearchTree implements SearchTree<Course> {