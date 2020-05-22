public class AdjList <T extends Object> implements FriendshipGraph<T> {

    SinglyLinkedList[] AdjList = null;

    public AdjList() {

    }

    //This is the constructor containing the error
    public AdjList(T vertices) {
        int qty = Integer.parseInt((String) vertices);
        AdjList = new SinglyLinkedList[qty];

        for (int i = 0; i < AdjList.length; i++)
            AdjList[i] = new SinglyLinkedList();
    }
}