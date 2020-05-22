// the Paint for the path
Paint p = new Paint();
p.setAntiAlias(true);
p.setColor(Color.BLACK);
p.setStyle(Style.FILL);
// the path
Path pth = new Path();      
pth.moveTo(50, 200); // example values, modify with your own, or to improve the path
pth.lineTo(70, 140);
pth.quadTo(150, 115, 230, 140);
pth.lineTo(250, 200);
pth.quadTo(150, 165, 50, 200);
pth.close();