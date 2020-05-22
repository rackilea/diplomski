canvas.save();
canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR); //clear everything drawn to the bitmap
canvas.rotate(refY, width/2, height/2);
canvas.drawLine(0, height/2, width, height/2, p);
canvas.restore();
btn.setText(Integer.toString(refY))