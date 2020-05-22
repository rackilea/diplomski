function DFS(node) {
     if (!node.visited) {
         node.visited = true;
         for (each edge {node, v}) {
             DFS(v);
         }
     }
 }