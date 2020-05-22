private LinkedList<Edge> recurse(LinkedList<Edge> path) {
    Edge last = path.getLast();
    Edge right = <get Edge to the right of last>;
    Edge bottom = <get Edge below last>;
    Edge left = <get Edge to the left of last>;
    Edge top = <get Edge above last>;
    if( right && !path.contains(right) ) {
        LinkedList<Edge> ps = path.clone();  // NOTE: check if the built-in clone() function does a shallow copy
        ps.addLast( right );
        paths.add( recurse(ps) );
    }
    if( bottom && !path.contains(bottom) ) {
        ...
    }
    if( left && !path.contains(left) ) {
        ...
    }
    if( top && !path.contains(top) ) {
        ...
    }
    return path;
}