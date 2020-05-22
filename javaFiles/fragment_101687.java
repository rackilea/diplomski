p.start(
  g.getVertices()
   .filter(new PipeFunction<Vertex,Boolean>() {    
             public Boolean compute(Vertex v) {
               // write your logic here to count edges on the vertex and 
               // return true if over 500 and false otherwise
             }));