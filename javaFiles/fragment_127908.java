// let n be the clicked node...
Iterator<Node> it = n.getBreadthFirstIterator(true);
while(it.hasNext()){
    Node m  =  it.next();
    for(Edge e : m.getLeavingEdgeSet()) {
        e.setAttribute("ui.hide");
    }
    if(n != m) {
        m.setAttribute("ui.hide");
    }
}