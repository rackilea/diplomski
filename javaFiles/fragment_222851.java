size(200, 200);
for(float diameter = 255; diameter > 0; diameter--){
  noStroke();
  fill(0, 255-diameter, 0); 
  ellipse(width/2, height/2, diameter, diameter);
}