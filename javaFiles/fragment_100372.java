g.drawString("Mouse " + (mouseEntered ? "entered" : "exited") + " at (" + x1 + ", " + y1 + ")", 25, 50);
if (mouseAction == 'c') {
    g.drawString("Mouse moved at (" + x2 + ", " + y2 + ")", 25, 25);
} else if (mouseAction == 'd') {
    g.drawString("Mouse clicked at (" + x1 + ", " + y1 + ")", 25, 25);
}