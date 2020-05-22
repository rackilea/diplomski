@Override
public void mouseDragged(MouseEvent e) {

    GeneralPath gp = new GeneralPath();
    gp.append(lineMn, false);
    gp.append(lineMp, false);

    Point p = e.getPoint();

    if (!gp.getBounds().contains(p)) {
        return;
    }