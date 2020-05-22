Rectangle bounds=shape.getBounds(); // changed this
...
//g.translate(this.getWidth()/2,this.getHeight()/2);
//g.translate(-width/2,-height/2);
g.translate((this.getWidth() - width) / 2,(this.getHeight() - height) / 2);
g.translate(-bounds.x, -bounds.y); // added this