//Graph holder
Graph<Integer, String> graph = new SparseMultigraph<Integer, String>();

//Create graph with this many nodes and edges
int nodes = 30;
for (int i = 1; i <= nodes; i++) {
    graph.addVertex(i);
    //connect this vertext to vertex+1 to create an edge between them.
    //Last vertex is connected to the first one, hence the i%nodes
    graph.addEdge("Edge-" + i, i, (i % nodes) + 1);
}

//This will automatically layout nodes into a circle.
//You can also try CircleLayout class
Layout<Integer, String> layout = new KKLayout<Integer, String>(graph);
layout.setSize(new Dimension(300, 300)); 

//Thing that draws the graph onto JFrame
BasicVisualizationServer<Integer, String> vv = new BasicVisualizationServer<Integer, String>(layout);
vv.setPreferredSize(new Dimension(350, 350)); // Set graph dimensions

JFrame frame = new JFrame("Circle Graph");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.getContentPane().add(vv);
frame.pack();
frame.setVisible(true);