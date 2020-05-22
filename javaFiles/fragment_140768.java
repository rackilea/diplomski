/**
 *
 * @author ssuman
 */

class FirstLastLinkedList{
    protected long data;
    protected FirstLastLinkedList next;
    protected FirstLastLinkedList() {
    }    
}

class CircularLinkedList {

    private FirstLastLinkedList head = null,temp = null, move = null, prev = null;
    // `temp` is used to store the last node just before the `head` node;
    protected void findInList(int userData){
        if(head==null){
            System.out.println("Can't find link with key "+ userData+"; List is empty!");
            return;
        }
        move = head;
        do{
            if(move.data == userData){
                System.out.println("Found link with key "+ userData);
                return;
            }
            move = move.next;
        }while(move != head);
        System.out.println("Can't find link with key "+ userData);
    }

    protected void deleteFromList(int userData){
        prev = move = head;
        if(head==null){
            System.out.println("Can't delete link with key "+ userData+"; List is empty!");
            return;
        }
        do{
            if(move.data == userData){
                prev = getPreviousNodeInList(move);
                head = move = move.next;
                prev.next = move;
                System.out.println("Deleted link with key "+ userData);
                displayList();
                return;
            }
            prev = move;
            move = move.next;
        }while(move != head);
        System.out.println("Can't delete link with key "+ userData);
    }

    protected FirstLastLinkedList getPreviousNodeInList(FirstLastLinkedList current){
        move = head;
        if(current == null){
            return null;
        }

        do{ 
            if(head == current){
                return temp;
            }
            if(move == current){
                return prev;
            }
            prev = move;
            move = move.next;
        }while(move != head);
        return null;
    }

    protected void insertInList(int userData){
        if(head==null){
            head = new FirstLastLinkedList();
            System.out.println("Inserting Link with key "+userData);
            head.data = userData;
            head.next = null;   
            move = head;
        }
        else{
            temp = new FirstLastLinkedList();
            System.out.println("Inserting Link with key "+userData);
            temp.data = userData;
            move.next = temp;
            move = temp;
        }
    }

    protected void endList(){
        temp.next = head;
    }

    protected void stepThroughList(){
        if(head == null){
            System.out.println("List is empty...");
            return;
        }
        FirstLastLinkedList temporary;
        System.out.println("Stepping through List :- ");
        temporary = head;
        do{
            move = temporary;
                do{          
                    System.out.print(move.next.data+"  ");  
                    move = move.next;
                }while(move != temporary);
            temporary = temporary.next;
            System.out.println("");
        }while(temporary != head);
    }

    protected void deleteInStepsFromList(){
        System.out.println("Will delete and step one by one :- ");
        prev = move = head;
        if(head==null){
            System.out.println("Can't delete links ; List is empty!");
            return;
        }
        do{
            prev = getPreviousNodeInList(move);
            head = move = move.next;
            prev.next = move;
            displayList();
        }while(move != prev);
    }

    protected void displayList(){
        move = head;
        System.out.print("List :  ");
        do{
            System.out.print(move.data+"  ");
            move = move.next;
        }while(move != head);
        System.out.println();
    }
}

public class TestCircularLinkedList{
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.insertInList(10);
        cll.insertInList(20);
        cll.insertInList(30);
        cll.insertInList(40);
        cll.insertInList(50);
        cll.insertInList(60);
        cll.insertInList(70);
        System.out.println("The List ended here...");
        cll.endList();
        cll.stepThroughList();
        cll.findInList(10);
        cll.findInList(33);
        cll.displayList();
        cll.deleteFromList(100);
        cll.deleteInStepsFromList();
    }
}