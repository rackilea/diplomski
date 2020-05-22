public class Heap {

public static void main(String[] args) {
 maxheap obj= new maxheap();
 obj.insert(12);
 obj.insert(7);
 obj.insert(6);
 obj.insert(10);
 obj.insert(8);
 obj.insert(20);

 obj.preorder(obj.rroot());
}


}