public void paintComponent(Graphics g) {        
    paintComponent(g, rootNode)
}

public void paintComponent(Graphics g, Nodes curRoot) {        
    ...
    nodePrintList = getChildren(curRoot);  
    for (Nodes n : nodePrintList) {     
        System.out.println("\nChildren of " + rootNode.getValue() + ": " + n.getValue());
        ...
        paintComponent(g, n);
    }
}