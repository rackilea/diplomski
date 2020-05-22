public static void main(String[] args) {
    try {
        GraphExample graph=new GraphExample(new JFrame(),"Testing");
        graph.createGraphPanel();
        graph.setVisible(true);  // ****** add *****
    } catch (Exception e) {
        e.printStackTrace();
    }
}