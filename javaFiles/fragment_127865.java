// from your code
rectangle.setBackgroundColor(ColorConstants.green);

// new code
RectangleFigure r2 = new RectangleFigure();
r2.setBounds(new Rectangle(0,0,10,10));
r2.setBackgroundColor(ColorConstants.blue);
rectangle.add(r2);

// back to your code
lws.setContents(rectangle);