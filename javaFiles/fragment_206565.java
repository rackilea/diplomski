public class Node<T extends Comparable<T>> {
    protected Node<T> left;
    protected Node<T> right;
    protected T data;   
}

public class BTree<T extends Comparable<T>> {
    private Node<T> root = new Node<>();
    public void addData(T data) {
        Node<T> parent = root;
        while (parent.data != null ) {
            if ( data.compareTo( parent.data ) > 0 ) {
                if ( parent.right == null ) 
                    parent.right = new Node<>();
                parent = parent.right;
            } else {
                if ( parent.left == null ) 
                    parent.left = new Node<>();
                parent = parent.left;
            }
        }
        parent.data = data;
    }
}

private void run() {
    for ( int i = 2; i < 65; ++i ) {
        List<Integer> intList = IntStream.range(1, i).boxed().collect(Collectors.toList());
        BTree<Integer> bTree = new BTree<>();
        List<List<Integer>> splitLists = new ArrayList<>();
        splitLists.add(intList);
        while (splitLists.size() > 0 ) {
            List<List<Integer>> tSplitLists = new ArrayList<>();
            for ( List<Integer> tIntList: splitLists) {
                int length = tIntList.size();
                // compute starting point
                int mid = calcMid(length);      // length/2 ; //+ calcOffset(length);
                bTree.addData(tIntList.get(mid));
                if ( mid - 0 > 0)
                    tSplitLists.add(tIntList.subList(0, mid));
                if ( length - (mid+1) > 0)
                    tSplitLists.add(tIntList.subList(mid+1, length));
            }
            splitLists = tSplitLists;
        }
        bTree.printNode();
    }
}
private int calcMid(int length) {
    if ( length <= 4 )
        return length / 2;
    int levelSize = 1;
    int total = 1;
    while ( total < length ) {
        levelSize *= 2;
        total += levelSize;
    }
    int excess = length - (total - levelSize);
    int minMid = (total - levelSize + 1) / 2;
    if ( excess <= levelSize / 2 ) {
        return minMid + (excess - 1); 
    } else {
        int midExcess = levelSize/2; 
        return minMid + (midExcess - 1);
    }

}