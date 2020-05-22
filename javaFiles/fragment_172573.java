try (Transaction Tx = gdbs.beginTx(){
    Node nodo = gdbs.createNode();
    nodo.addLabel(p);   // if you have Labels
    nodo.setProperty("property1", someValue);
    Tx.success();
    Tx.close();
} catch (Exception e){//do something}