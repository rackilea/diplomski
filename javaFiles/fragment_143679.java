final Canvas canvas=..;
canvas.addPaintListener(new PaintListener() { 
    public void paintControl(PaintEvent e) { 
        e.gc.drawRectangle(50,50,45,45);
    }
});