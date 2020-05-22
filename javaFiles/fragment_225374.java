public class Queue {
    private Vector<String>  data ;

    Queue(){
    data = new Vector();
    }
    public void enqueue(String item){
    data.add(item);
    }

    public void dequeue(){
    data.remove(0);
    }


    public void printQueueItems(){

       int length = data.size();
        for(int i = 0; i < length; i++){
            System.out.println(data.get(i));
        }
    }

    public static void main(String[] args) {  
    Queue myQ = new Queue();

    myQ.enqueue("hello");
    myQ.enqueue("world");
    myQ.enqueue("!");
    myQ.printQueueItems();

    }

}