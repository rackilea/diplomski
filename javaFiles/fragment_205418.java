public class CharTest {
    public static class Node {
        private char content;
        private Node nextNode;

        public Node () {
            content = '\0';
            nextNode = null;
        }

        public Node (String str) {
            Node temp = this;
            for (int i = 0; i < str.length(); i++) {
                temp.content = str.charAt(i);
                temp.nextNode = new Node();
                temp = temp.nextNode;
            }
        }

        public char charAt(int index) {
            if (index == 0) {
                return content;
            } else if (index < 0 || nextNode == null) {
                throw new IndexOutOfBoundsException();
            }
            return nextNode.charAt(index - 1);
        }
    }
    public static void main(String[] args) {
        Node test = new Node("StackOverflow");
        for (int i = 0; i < 13; i++) { 
            System.out.print(test.charAt(i));
        }
        System.out.println();
    } 
}