private static MouseListener whichOneListener = new MouseAdapter() {
    public void mouseClicked( MouseEvent e ) {
        JComponent c = ( JComponent ) e.getSource();
        JLabel l  = ( JLabel ) c.getComponentAt( e.getPoint() );
        System.out.println( l.getText() );
    }

};