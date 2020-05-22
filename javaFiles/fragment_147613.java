// Learning Processing
// Daniel Shiffman
// http://www.learningprocessing.com

// Example: a graph of random numbers

float[] vals;

PGraphics graph;

void setup() {
  size(400,200);
  graph = createGraphics(width,height);

  // An array of random values
  vals = new float[width];
  for (int i = 0; i < vals.length; i++) {
    vals[i] = random(height);
  }
}


void draw() {
  graph.beginDraw();
  graph.background(255);
  // Draw lines connecting all points
  for (int i = 0; i < vals.length-1; i++) {
    graph.stroke(0);
    graph.strokeWeight(2);
    graph.line(i,vals[i],i+1,vals[i+1]);
  }
  graph.endDraw();
  image(graph,0,0); 

  // Slide everything down in the array
  for (int i = 0; i < vals.length-1; i++) {
    vals[i] = vals[i+1]; 
  }
  // Add a new random value
  vals[vals.length-1] = random(height);//use seismograph.getCurrentValue(); here instead

}