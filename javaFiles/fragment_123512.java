Input.treeNodes.stream()
         .map(treeNode -> {
             treeNode.init(gl3);
             Current.treeNodes.put(treeNode.getId(), treeNode);
         });
Input.treeNodes.clear();