if(button1.isSelected()){
    Polygon p = new Polygon();
    for (int x = 0; x <= 4; x++) {
        p.addPoint(w+x, h - ((x*x*x) + x - 3));
    }
    g2.drawPolyline(p.xpoints, p.ypoints, p.npoints);
}
else if(button1.isSelected()){
    //other polygon
}
//etc...