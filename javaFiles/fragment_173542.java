if(targettile!=null){
    yourobject.position.x += 1*delta;
    if(yourobject.position.x>=targettile.position.x){
        yourobject.position.x = targettile.position.x;
        targettile = null;
    }
}