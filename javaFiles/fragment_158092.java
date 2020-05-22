@Override
public void mousePressed(MouseEvent e) {
    if (pSize<4){
        punkter.add(new Point(e.getX(), e.getY()));
        controlPoints[pSize] = punkter.get(pSize);
        pSize++;
        repaint();
    } else if (pSize==4){
        // do other stuff, for example reset everything and start over

        //pSize = 0;
        //punkter.clear();
        //for (int i= 0; i < controlPoints.length; i++){
        //    controlPoints[i]= null;
        //}
        //repaint();
        //System.out.println("Reset");
    }
}