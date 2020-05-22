public void keyPressed(KeyEvent e) throws FileNotFoundException, InterruptedException{
    ArrayList GNodes = PlayIG.getGNodes();
    GNode GN = (GNode) GNodes.get(0);
    System.out.println("" + m + " " + GNodes);
    int key = e.getKeyCode();
    ImageIcon S1iExact = new ImageIcon("D:\\JavaProject\\Graphic-library\\buttons\\String01_Exact.png");
    ImageIcon S1iMissed = new ImageIcon("D:\\JavaProject\\Graphic-library\\buttons\\String01_Missed.png");
    if (key == KeyEvent.VK_F1){
            if (GN.getY()+47>=370 && GN.getY()+47<=420)
                S1 = S1iExact.getImage();
            else
                S1 = S1iMissed.getImage();

    }