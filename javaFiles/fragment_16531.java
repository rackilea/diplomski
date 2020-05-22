@Transaction
public String doStuff() {
    List<Confirmchemtemp> list = getAllconfirm();
    int key = insert(parameters);
    if (key == 0) {
        throw new TransactionException("nothing inserted");
    }
    insertTrans(parameters);
    insertTransdet(parameters);
    update(parameters); 
}