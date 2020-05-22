package mergesortlinkedlist;

public class MergeSortLinkedList {

    // static Node first = new Node();
    static LinkedList list = new LinkedList();

    public static void main(String[] args) {
        // start linked list
        list.add(list, 1);
        list.add(list, 5);
        list.add(list, 3);
        list.add(list, 4);
        list.add(list, 2);
        list.add(list, 100);
        list.add(list, 76);
        list.add(list, -6);

        list.printList(list);

        naturalMerge(list);

        list.printList(list);

        naturalMerge(list);

        list.printList(list);

        naturalMerge(list);

        list.printList(list);

    }

    public static void naturalMerge(LinkedList front) {
        LinkedList set1 = new LinkedList();
        LinkedList set2 = new LinkedList();
        LinkedList temp = front;
        int size1 = 0;
        int sortCounter = 0;        //if sortCounter != 0, then there is more to sort

        //get first temp list
        while (temp.head.data != null) {

            if (temp.head.data < temp.head.next.data) {

                set1.add(set1, temp.head.data);
                size1++;
                temp.head = temp.head.next;

            } else {
                set1.add(set1, temp.head.data);
                size1++;
                temp.head = temp.head.next;
                break;

           }
        }

        //get second temp list
        while (temp.head != null) {

            if (temp.head.next == null) {
                set2.add(set2, temp.head.data);
                temp.head = temp.head.next;
                break;
            }
            if (temp.head.data < temp.head.next.data) {

                set2.add(set2, temp.head.data);

                temp.head = temp.head.next;

            } else {

                set2.add(set2, temp.head.data);

                temp.head = temp.head.next;

                break;

            }
        }

        mergeSwap(set1, set2, size1);
    }

    public static void mergeSwap(LinkedList set1, LinkedList set2, int size1)  {

        System.out.println();
        LinkedList temp = set1;
        LinkedList temp2 = set2;


        while (temp.head != null && temp2.head != null) {

            if (temp.head.data < temp2.head.data) {

                list.add(list, temp.head.data);
                temp.head = temp.head.getNext();    //increment temp

            } else {

                list.add(list, temp2.head.data);
                temp2.head = temp2.head.getNext();  //increment temp2

            }

            //if one list is empty, break loop and add remaining nodes
            if (temp.head == null || temp2.head == null) {
               break;
            }

        }
        //check which list is empty, and add the remaining nodes to original list
        if (temp.head == null) {
            while (temp2.head != null) {
               list.add(list, temp2.head.data);
               temp2.head = temp2.head.getNext();
           }
        } else {
            while (temp.head != null) {
               list.add(list, temp.head.data);
               temp.head = temp.head.getNext();
            }
        }

        //naturalMerge(list);     //this call breaks the code, but why? How is it any different from the method call in main?
    }
}