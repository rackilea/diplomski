public class HorizontalOverlappingTreeLayout<V, E> extends TreeLayout<V, E> {

    public static void main(String[] args) {
        Set<Integer> set0 = new HashSet<Integer>();
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        set0.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(5);
        set2.add(6);
        set2.add(7);

        JPanel panel = new JPanel();
        Graph<Integer, String> graph = new DelegateForest<Integer, String>();
        Integer vertex1 = set0.iterator().next();
        for (Integer i : set1) {
            graph.addEdge(vertex1 + "-" + i, vertex1, i);
        }

        Layout<Integer, String> layout = new HorizontalOverlappingTreeLayout<Integer, String>(
                (Forest<Integer, String>) graph);
        VisualizationViewer<Integer, String> vv = new VisualizationViewer<Integer, String>(layout);
        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<Integer>());
        panel.add(vv);

        JFrame frame = new JFrame();
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public HorizontalOverlappingTreeLayout(Forest<V, E> g) {
        super(g);
    }

    @Override
    protected void buildTree() {
        this.m_currentPoint = new Point(0, 20);
        Collection<V> roots = TreeUtils.getRoots(graph);
        if (roots.size() > 0 && graph != null) {
            calculateDimensionY(roots);
            for (V v : roots) {
                calculateDimensionY(v);
                m_currentPoint.y += this.basePositions.get(v) / 2 + this.distY;
                buildTree(v, this.m_currentPoint.y);
            }
        }
        // TODO: removed code here
    }

    @Override
    protected void buildTree(V v, int y) {
        if (!alreadyDone.contains(v)) {
            alreadyDone.add(v);

            // go one level further down
            this.m_currentPoint.x += this.distX;
            this.m_currentPoint.y = y;

            this.setCurrentPositionFor(v);

            int sizeYofCurrent = basePositions.get(v);

            int lastY = y - sizeYofCurrent / 2;

            int sizeYofChild;
            int startYofChild;

            for (V element : graph.getSuccessors(v)) {
                sizeYofChild = this.basePositions.get(element);
                startYofChild = lastY + sizeYofChild / 2;
                buildTree(element, startYofChild);
                lastY = lastY + sizeYofChild + distY;
            }
            this.m_currentPoint.x -= this.distX;
        }
    }

    private int calculateDimensionY(V v) {
        int size = 0;
        int childrenNum = graph.getSuccessors(v).size();

        if (childrenNum != 0) {
            for (V element : graph.getSuccessors(v)) {
                size += calculateDimensionY(element) + distY;
            }
        }
        size = Math.max(0, size - distY);
        basePositions.put(v, size);

        return size;
    }

    private int calculateDimensionY(Collection<V> roots) {
        int size = 0;
        for (V v : roots) {
            int childrenNum = graph.getSuccessors(v).size();

            if (childrenNum != 0) {
                for (V element : graph.getSuccessors(v)) {
                    size += calculateDimensionY(element) + distY;
                }
            }
            size = Math.max(0, size - distY);
            basePositions.put(v, size);
        }

        return size;
    }

}