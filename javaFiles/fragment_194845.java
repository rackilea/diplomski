public class Combine {

    public static final int nNodes = 3;
    public static final int nPersons = 3;

    // nodes
    private Node[] nodes;
    private int nUnvisitedNodes = nNodes;

    // solution
    private Node[][] sol = new Node[nPersons][];

    // no of solutions already found and printed
    int nSolutions = 0;

    public Combine() {
        // init nodes
        nodes = new Node[nNodes];
        for (int nix = 0; nix < nodes.length; nix++) {
            nodes[nix] = new Node(nix + 1); // node names are 1-based
        }

        // search for solutions -- person 0 first
        tryPerson0();
    }

    private void tryPerson0() {
        if (nUnvisitedNodes == 0) { // done
            printSolution();
        } else {
            // assuming this is not the last person, this person may visit 1 through nUnvisitedNodes nodes
            // (in a canonical solution person 0 cannot visit 0 nodes)
            int maxVisits = nUnvisitedNodes;
            for (int nNodesToVisit = 1; nNodesToVisit <= maxVisits; nNodesToVisit++) {
                sol[0] = new Node[nNodesToVisit];
                tryNode(0, sol[0], 0);
                sol[0] = null;
            }
        }
    }

    private void tryPerson(int person) {
        assert person > 0;
        if (nUnvisitedNodes == 0) { // solution complete
            printSolution();
        } else {
            if (person < nPersons) { // still persons to try
                if (person == nPersons - 1) { // this is the last person
                    // person must visit all remaining nodes
                    // in a canonical solution, first node must be greater than first node visited by previous person
                    int nNodesToVisit = nUnvisitedNodes;
                    sol[person] = new Node[nNodesToVisit];
                    tryNodeWithMininum(person, sol[person], 0, sol[person - 1][0].name + 1);
                    sol[person] = null;
                } else {
                    // since this is not the last person, this person may visit 1 through nUnvisitedNodes nodes
                    // in a canonical solution, first node must be greater than first node visited by previous person
                    int maxVisits = nUnvisitedNodes;
                    for (int nNodesToVisit = 1; nNodesToVisit <= maxVisits; nNodesToVisit++) {
                        sol[person] = new Node[nNodesToVisit];
                        tryNodeWithMininum(person, sol[person], 0, sol[person - 1][0].name + 1);
                        sol[person] = null;
                    }
                }
            }
        }
    }

    private void tryNode(int person, Node[] personSol, int nix) {
        if (nix == personSol.length) { // this person's solution complete
            tryPerson(person + 1);
        } else {
            for (Node candidateNode : nodes) {
                if (candidateNode.visit()) {
                    personSol[nix] = candidateNode;
                    tryNode(person, personSol, nix + 1);
                    personSol[nix] = null;
                    candidateNode.unvisit();
                }
            }
        }
    }

    private void tryNodeWithMininum(int person, Node[] personSol, int nix, int minNodeName) {
        for (Node candidateNode : nodes) {
            if (candidateNode.getName() >= minNodeName) {
                if (candidateNode.visit()) {
                    personSol[nix] = candidateNode;
                    tryNode(person, personSol, nix + 1);
                    personSol[nix] = null;
                    candidateNode.unvisit();
                }
            }
        }
    }

    private void printSolution() {
        nSolutions++;
        System.out.println("> Sol " + nSolutions);
        for (int pix = 0; pix < nodes.length; pix++) {
            System.out.println("Person " + pix + " = " + Arrays.toString(sol[pix]));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        new Combine();
    }

    private class Node {
        int name;
        boolean visited = false;

        public Node(int name) {
            this.name = name;
        }

        /** visits node if not already visited */
        public boolean visit() {
            if (visited) {
                return false;
            } else {
                visited = true;
                nUnvisitedNodes--;
                return true;
            }
        }

        /** undoes visit (that is, backtracks) */
        public void unvisit() {
            assert visited : name;
            nUnvisitedNodes++;
            visited = false;
        }

        public int getName() {
            return name;
        }

        @Override
        public String toString() {
            return String.valueOf(name);
        }
    }

}