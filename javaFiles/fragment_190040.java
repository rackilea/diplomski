public class Bucket extends Class1 {
    LinkedList<String> linkedList;

    public Bucket(){
        super(new LinkedList<String>()); 
        //now typecast and assign collection to linkedList
        linkedList = (LinkedList<String>)collection;
    }

    public String getFirst() {
        return linkedList.getFirst(); 
     } 
 }