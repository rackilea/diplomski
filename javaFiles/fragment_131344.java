public <V, E> void bstdraw(Graph<V, E> g) {

    V start = null;

    for (V v : g.getVertices()) {
        if (v.toString().equals(jTextField1.getText())) {
            start = v;
        }
    }

    Set visited = new HashSet();
    LinkedList stack = new LinkedList();
    stack.add(start);
    visited.add(start);
    l.add(start);
    // traverse through graph in depth-first order
    while (!stack.isEmpty()) {
        V v = (V) stack.removeFirst();
        Set neighbors = (Set) g.getNeighbors(v);
        //System.out.println(v);

        for (Iterator n_it = neighbors.iterator(); n_it.hasNext();) {
            V w = (V) n_it.next();

            if (!visited.contains(w)) {
                l.add(w);
                g2.addEdge("edge" + w, (Integer) v, (Integer) w);
                jPanel4.repaint();
                jPanel4.updateUI();

                visited.add(w);
                stack.addLast(w);

            }
        }
    }

    for (int i = 0; i < l.size(); i++) {

        jTextField3.setText(jTextField3.getText() + " " + l.get(i));

    }
}