...
 if ( this.serializedNodes.contains(node) ) {
    this.emmitter.emit( new AliasEvent( ... ) );
 } else {
    serializedNodes.add(node); // <== Replace with myHook(serializedNodes,node);
 ...

 void myHook(serializedNodes,node) {
    if ( node's class != myClass(es) to avoid ) {
        serializedNodes.add(node);
    }