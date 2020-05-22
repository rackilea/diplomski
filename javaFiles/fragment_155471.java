private LinkedList<T> resultList; 

 public LinkedList<T> experiment(T vertex){
    resultList = new LinkedList<T>();
    return experimentRecursive(vertex);
 }