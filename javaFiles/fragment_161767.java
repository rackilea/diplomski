import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class BSTMap<K extends Comparable<K>,V> implements Map61B<K,V> {

    Node root;
    int size;

    class Node{
        K key;
        V value;
        Node left,right,parent; 

        public Node(){}

        public Node(K k,V v,Node p){
            //System.out.println(k+" "+v+" "+p);
            key=k;
            value=v;
            parent=p;
        }
    }


    public class KeyIterator implements Iterator<K>{
        private ArrayList<K> keys;
        private int counter;

        public KeyIterator(){
            counter=0;
            keys=new ArrayList<K>();
            inOrder(root,keys);

            System.out.println("KeyIterator()");
            for(K k:keys)
                System.out.print(k+" ");
            System.out.println();

        }

        public boolean hasNext(){
            return counter<keys.size();
        }

        public K next(){
            return keys.get(counter++);
        }
        public void remove(){

        }
    }

    public Iterator<K> iterator(){
     Iterator<K> seer=new KeyIterator();

     return seer;
 }


 public static void main(String[] args) {
     BSTMap<String, String> a = new BSTMap<String, String>();
     BSTMap<String, Integer> b = new BSTMap<String, Integer>();

     b.put("H", 1);
     b.put("D", 2);
     b.put("I", 3);
     b.put("B", 4);
     b.put("E", 5);
     b.put("A", 6);
     b.put("C", 7);
     b.put("F", 7);
     b.put("G", 7);
     b.put("L", 7);
     b.put("I", 7);
     b.put("J", 7);
     b.put("N", 7);
     b.put("M", 7);
     b.put("O", 7);

     Iterator<String> seer=b.iterator();
     while(seer.hasNext()){
         System.out.println(seer.next());
     }

 }
}