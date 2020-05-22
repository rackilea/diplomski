String input =  "0-1 0-2 1-2 1-3 2-3";
  int x,y;

  for(int i = 0; i < input.length(); i+=4)
  {
   x = Character.getNumericValue(input.charAt(i));   // first vertex 
   y = Character.getNumericValue(input.charAt(i+2)); // second vertice 
   matrix_graph[x][y] = true;
   matrix_graph[y][x] = true; // if the graph is not oriented.
  }