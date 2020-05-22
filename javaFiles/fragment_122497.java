open XML  
while xml source has next  
  {  
  add next node to allNodes, key = node.uniqueId, Val = node  
  if next node.kind not in uniqueKinds, add node.kind to uniqueKinds  
  }



ClassNodeImporter method makeFilteredeMap:  

    private boolean makeFilteredeMap() {
        if (uniqueKinds.isEmpty()) {
            return false;
        } else {
            for (String k : uniqueKinds) {
                HashMap<String, Node> aMap = new HashMap<String, Node>();
                for (Node n : allNodes) {
                    if (n.getKind().equals(k)) {
                        aMap.put(n.getCode(), n);
                    }
                }
                filteredNodes.put(k, aMap);
            }
            return true;
        }
    }