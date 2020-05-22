Queue<NodeWithLevel> queue;
queue.enqueue(<0, tree.root>);    
currentLevel = 0;
while(currentLevel < N) {
    NodeWithLevel current = queue.dequeue();
    currentLevel = current.level;
    // do whatever with current
    for(Node child: current.node.children) {
       queue.enqueue(<current.level + 1, child>);
    }        
}