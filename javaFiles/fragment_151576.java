itX = x.iterator();
itY = y.iterator();
while(itX.hasNext()){
    Integer xx = (Integer) itX.next();
    Integer yy = (Integer) itY.next();
    g2d.fillOval(xx, yy, 30, 30);
}