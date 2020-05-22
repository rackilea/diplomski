@Override
public void mousePressed(MouseEvent e) {
    if (pSize==4) {
        drawBezier(pSize,4,getGraphics());
        return;
    }
    drawPoint(e);   
    pSize++;
}