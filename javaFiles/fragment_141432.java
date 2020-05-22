//assumes tex is already initialized/loaded PImage
beginShape();
texture(tex);
vertex(-150,-150,0,    0,  0);//top-left
vertex( 150,-150,0,  100,  0);//top-right
vertex( 150, 150,0,  100,100);//bottom-right
vertex(-150, 150,0,    0,100);//bottom-left
endShape();