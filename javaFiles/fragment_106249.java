public class Main {
    private Node start;

    public void addByAge(Node newNode) {
        if (start == null) {
            start = newNode;
        } else {
            Node headTemp = start;
            Node temp = null;
            while (headTemp.getNext() != null) {
                if (newNode.getAge() > headTemp.getAge() && temp != null) {
                    temp.setNext(newNode);
                    newNode.setPrev(temp);
                    newNode.setNext(headTemp);
                    headTemp.setPrev(newNode);
                    break;
                } else {
                    temp = headTemp;
                    headTemp = temp.getNext();
                }
            }
            if (newNode.getAge() > headTemp.getAge()) {
                if (temp != null) {
                    temp.setNext(newNode);
                    newNode.setPrev(temp);
                    newNode.setNext(headTemp);
                    headTemp.setPrev(newNode);
                } else {
                    start = newNode;
                    newNode.setNext(headTemp);
                    headTemp.setPrev(newNode);
                }

            } else {
                headTemp.setNext(newNode);
                newNode.setPrev(headTemp);
            }
        }
    }

    // Create a reference of my List class and add some dummy data sorted by age
    public static void main(String[] args) {
        Main people = new Main();
        people.addByAge(new Node(97, "Anderson"));
        people.addByAge(new Node(100, "Andy"));
        people.addByAge(new Node(79, "Anfinsen"));
        people.addByAge(new Node(59, "Banerjee"));
        people.addByAge(new Node(84, "Bishop"));
        people.addByAge(new Node(78, "Bridgman"));
        people.printPeopleList();
    }

    // Print the list. Print again in reverse order once the end of the list is reached
    private void printPeopleList() {
        Node temp = start;
        while (temp.getNext() != null) {
            System.out.println(temp.getLastName() + ", " + temp.getAge());
            temp = temp.getNext();
        }
        System.out.println(temp.getLastName() + ", " + temp.getAge());
        while (temp != null) {
            System.out.println(temp.getLastName() + ", " + temp.getAge());
            temp = temp.getPrev();
        }
    }
}