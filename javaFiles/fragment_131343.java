public <V, E> void dftdraw(Graph<V, E> g) {

    V start = null;

    for (V v : g.getVertices()) {
        if (v.toString().equals(jTextField2.getText())) {
            start = v;
        }

    }

    if(!visiteddfs.contains(start)) {
        dfspath(g,start);
    }


    for(int i=0;i<l2.size();i++){

        jTextField4.setText(jTextField4.getText() + " " + l2.get(i));
    }

}

public <V,E> void dfspath(Graph<V,E> g,V v){

    visiteddfs.add(v);
    l2.add(v);
    Set neighbors = (Set) g.getNeighbors(v);
        //System.out.println(v);

        for (Iterator n_it = neighbors.iterator(); n_it.hasNext();) {
            V w = (V) n_it.next();

        if(!visiteddfs.contains(w)){

            dfspath(g,w);
        }

    }
    finisheddfs.add(v);

}