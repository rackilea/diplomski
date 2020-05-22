public class Example {
private int ID;
private int ans;
private String name;
public Example next;

public Example(int ID, String name) {
    this.ID = ID;
    this.name = name;
}

public void display() {
    System.out.println("ID: " + ID + " - " + name);
}

public static void main(String args[]) throws IOException {
    int userId;
    String userName;
    BufferedReader inpt = new BufferedReader(new InputStreamReader(
            System.in));

    int x = 0;
    LinkList myLinkedList = new LinkList();

    while (x <= 2) {
        System.out.print("Enter Name: ");
        userName = inpt.readLine();

        System.out.print("Input ID#: ");
        userId = Integer.parseInt(inpt.readLine());

        System.out.println();

        myLinkedList.insertFirstLink(userName, userId);
        x++;
    }

    /*
     * myLinkedList.insertFirstLink("Vishera", 2341);
     * myLinkedList.insertFirstLink("Bulldozer", 1234);
     * myLinkedList.insertFirstLink("Allendale", 3214);
     * myLinkedList.insertFirstLink("Wolfdale", 4312);
     */

    myLinkedList.displayLink();

}

public String toString() {
    return name;
}

}

class LinkList {
public Example head;
public Example tail;

public LinkList() {
    head = null;
    tail = head;
}

public boolean isEmpty() {
    return (head == null);
}

public void insertFirstLink(String name, int ID) {
    Example newLink = new Example(ID, name);
    if (head == null) {
        head = newLink;
        tail = newLink;
    } else {
        tail.next = newLink;
        tail = newLink;
    }
}

public void displayLink() {
    Example theLink = head;

    while (theLink != null) {
        theLink.display();

        System.out.println("The Next Link: " + theLink.next);

        theLink = theLink.next;

        System.out.println();

    }
}
}