import java.util.ArrayList;
import java.util.ListIterator;

public class MergeLinkedListsIntoExisting {
    public static void main(String[] args){
        Node nodeList1 = null, nodeList2 = null;
        Node temp = null;
        ArrayList<Integer> array1 = new ArrayList<Integer>();
        array1.add(3);
        array1.add(7);
        array1.add(9);

        ArrayList<Integer> array2 = new ArrayList<Integer>();
        array2.add(1);
        array2.add(2);
        array2.add(8);

        nodeList1 = add(nodeList1, array1);
        nodeList2 = add(nodeList2, array2);
        System.out.println("**List 1**");
        print(nodeList1);
        System.out.println("**List 2**");
        print(nodeList2);
        System.out.println("Sorted List");
        Node nodeList3 = mergeTwoLists(nodeList1, nodeList2, temp);
        print(nodeList3);
    }
    private static Node add(Node node, ArrayList<Integer> list){
        Node current = node;
        Node head = node;
        ListIterator<Integer> it = list.listIterator();
        while(it.hasNext()){
            if(head==null){
                head = new Node();
                head.data = it.next();
                head.next=null;
                node = head;
            }
            else{
                current = new Node();
                current.data = it.next();
                current.next = null;
                node.next = current;
                node = node.next;
            }
        }
        return head;
    }

    private static void print(Node node) {
        if(node!=null){
            while(node.next!=null){
                System.out.print(node.data + " ");
                node = node.next;
            }
            System.out.println(node.data);
        }
        else{
            System.out.println("No elements in the linkedList.");
        }
    }


    private static Node mergeTwoLists(Node nodeList1, Node nodeList2, Node temp) {
        if(nodeList1 == null) return nodeList2;
        if(nodeList2 == null) return nodeList1;

        if(nodeList1.data <= nodeList2.data){

          temp = nodeList1;
          temp.next = mergeTwoLists(nodeList1.next, nodeList2, temp);

        }else{

          temp = nodeList2;
          temp.next = mergeTwoLists(nodeList1, nodeList2.next, temp);                
        }
        return temp;
    }
}

public class Node{
    int data;
    Node next;
}