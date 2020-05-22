public static void main(String args[]) {

    JFrame frame = new JFrame();
    PlotGraph graph = new PlotGraph();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 600);
    frame.add(graph);
    frame.setVisible(true); 
    frame.setTitle("PlotGraph");
}