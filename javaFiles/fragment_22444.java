public class ParentFrame extends JFrame{
    private static final long serialVersionUID = 1L;
    JLayeredPane desktop;
    JInternalFrame internalFrame;
    private List<Integer> myArrayList;

    public ParentFrame() {
        super("parent frame");
        myArrayList= new ArrayList<Integer>();
        myArrayList.add(8);
        myArrayList.add(6);
        myArrayList.add(7);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(600, 300));
        Panel p = new Panel();
        this.add(p, BorderLayout.SOUTH);
        desktop = new JDesktopPane();
        this.add(desktop, BorderLayout.CENTER);
        this.pack();
        this.setSize(new Dimension(600, 300));
        this.setLocationRelativeTo(null);
        final int DELTA = 40;
        int offset = DELTA;
        int ifWidth = 400;
        int ifHeight = 200;
        internalFrame = new JInternalFrame("internal frame", true, true, true, true);
        internalFrame.setLocation(offset, offset);
        offset += DELTA;

        JTabbedPane jtp = createTabbedPane();
        internalFrame.add(jtp);




        desktop.add(internalFrame);
        internalFrame.pack();
        internalFrame.setSize(new Dimension(ifWidth,ifHeight));
        internalFrame.setVisible(true);
    }


    private void createTab(JTabbedPane jtp, String s) {
        if(s=="Tab1"){
            TestGUI myTimeSeriesGUI = new TestGUI(myArrayList);
            jtp.add(s,myTimeSeriesGUI);
        }
        else{jtp.add(s, new JLabel("TabbedPane " + s, JLabel.CENTER));}
    }
}