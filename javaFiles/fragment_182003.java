dfs(root) = dfs0(root, new Set());
 dfs0(node, visited) = 
      if !visited.contains(node):
          visited.add(node)
          // do stuff for node
          foreach n in node.children:
              dfs0(n, visited)