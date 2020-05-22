static class Node {

    private static int nbOfNode = 0;
    private int value;

    Node(int v) {
        nbOfNode++;
        value = v;
    }

    int getValue() {
        return value;
    }

    static int getNbOfNode() {
        return nbOfNode;
    }
}