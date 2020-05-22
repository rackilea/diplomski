final JTabbedPane tabbedPane = new JTabbedPane();

MouseListener mouseListener = new MouseAdapter() {            
    Color defaultColor;

    @Override
    public void mouseEntered(MouseEvent e) {
        JLabel label = (JLabel)e.getSource();
        defaultColor = label.getForeground();
        label.setForeground(Color.BLUE);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JLabel label = (JLabel)e.getSource();
        label.setForeground(defaultColor);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JLabel label = (JLabel)e.getSource();
        Point point = SwingUtilities.convertPoint(label, e.getPoint(), tabbedPane);
        int selectedTab = tabbedPane.getUI().tabForCoordinate(tabbedPane, point.x, point.y);
        switch(e.getButton()){
            case MouseEvent.BUTTON2: tabbedPane.removeTabAt(selectedTab); break;
                default: tabbedPane.setSelectedIndex(selectedTab);
        }                
    }

};

JLabel tab1 = new JLabel("Tab1");
tab1.addMouseListener(mouseListener);    

tabbedPane.addTab(null, new JPanel());
tabbedPane.setTabComponentAt(0, tab1);