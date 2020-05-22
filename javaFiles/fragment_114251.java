public void plot(String ints, Graphics g) {
    ints = "put all nums here (e.g. 4,3;9,1;1.1,2)";
    String[] Part1 = ints.split(";");
    String coor1 = Arrays.(Part1[0]);
    String coor2 = Arrays.(Part1[2]);
    g.drawLine(50, 0, 2, heightOfFrame);
    g.drawLine(0, 50, widthOfFrame, 2);
    g.drawLine(45, 40, 10, 2);
    g.drawLine(40, 45, 2, 10);
    int coord1 = Integer.parseInt(coor1) * 10;
    int coord2 = Integer.parseInt(coor2) * 10;
    g.drawOval(coord1-1, coord2-1, 2, 2);
}