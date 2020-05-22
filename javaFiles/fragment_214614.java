public static void main(String[] args) {
    List<Integer> l = new ArrayList<Integer>(5);
    JFrame gui = new JFrame();
    gui.add(new MyPanel());
    l.add(10);
}

public class GUI extends JPanel {
    private List<Integer> l;
    public MyPanel(List<Integer> l) {
        this.l = l;
    }
    @Override
    public void paintComponent(Graphics g) { // this is called by JFrame.paint()
        super.paintComponent(g);
        List<Integer> modifiedL = new ArrayList<Integer>(l.size());
        for(Integer i : l) {
            modifiedL.add(2 * i);
        }
        // this is a stupid example, because it makes no sense to 
        // use this loop with l.size() here, but it shows the main problem. 
        for(int c = 0; c < l.size(); c++) { 
             somehowDrawSthWith(modifiedL.get(c));
        }
    }
}