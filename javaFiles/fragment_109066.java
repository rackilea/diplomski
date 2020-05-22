public class LinkedLists{
    private LinkedList<String> liste = new LinkedList<String>(); 

    public static void main(String[] args) {

        LinkedLists linkedListsInstance= new LinkedLists();
        linkedListsInstance.addToList("Mario");
        linkedListsInstance.printList();

    }

    public void addToList(String pElement) {
        liste.add(pElement);
    }

    public void printList(){
        System.out.println(liste);
    }

}