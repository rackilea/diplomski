graph.forEachRelationship(node, direction, (source, target, relId, weight) -> {
   updateCosts(source, target, weight + costs);
   if (!visited.contains(target)) {
       queue.add(target, 0);
   }
   return true;
});