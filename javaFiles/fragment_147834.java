public class TestInteger implements Comparable{
    // This is the User Interface for manipulating the List

    static SortedLinkedList sll = new SortedLinkedList ();
    Node head = null;

    public static void nodeMenu() {

        // no changes in this part ...

                    Integer insertItem = new Integer(x);
                    head = sll.insert(head, insertItem);
                }catch(InputMismatchException e){
                    System.out.println("Enter only integers");
                    sc.nextLine();
                }
            }