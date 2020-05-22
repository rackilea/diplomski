public static void main(String[] args){
    new GUITest();
}

public GUITest() {
    frame = new JFrame("test");
    frame.setSize(300,300);
    addStuffToFrame();
    SwingUtilities.invokeLater(new Runnable(){
        public void run() {
            frame.setVisible(true);
        }
    });

}       

private void addStuffToFrame() {    
    Panel awtPanel = new Panel();
    awtPanel.setBackground(Color.blue);
    //here you can fool around with the pane:
    //first, you can see how the layered pane works by switching the 
    //DEFUALT_LAYER and PALLETTE_LAYER back and forth between the two panels
    //and re-compiling to see the results
    awtPanel.setSize(200,300);
    frame.getLayeredPane().add(awtPanel, JLayeredPane.DEFAULT_LAYER);
    //next you comment out the above two lines and 
    //uncomment the following line. this will give you the desired effect of
    //awtPanel filling in the entire frame, even on a resize. 
    //frame.add(awtPanel);

    Panel awtPanel2 = new Panel();
    awtPanel2.setBackground(Color.red);
    awtPanel2.setSize(300,200);
    frame.getLayeredPane().add(awtPanel2,JLayeredPane.PALETTE_LAYER);
}