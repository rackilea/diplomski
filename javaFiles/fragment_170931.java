PriorityQueue<Edge> edges = new PriorityQueue<Edge>();
edges.add(new Edge(1, 2, 23));
edges.add(new Edge(2, 3, 1000));
edges.add(new Edge(1, 3, 43));

Edge temp;
while ((temp = edges.poll()) != null) 
 System.out.println(temp);