Request1:
    Transaction.begin() // Hybris Counter = 1
    doSomething() // This throws Exception, Application Exit, Hybris Counter is still 1
    try {
        Transaction.commit()
    } catch (Exception e) {
        Transaction.rollback();
    }

Request2 on same thread:
    Transaction.begin() // Hybris Counter now is 2
    doSomething() // Works OK, Hybris Counter is still 2
    try {       
        Transaction.commit() // HybrisCounter -= 1
        // Transaction is not commited to DB because Hybris counter now is 1
    } catch (Exception e) {
        Transaction.rollback();
    }

Request3 on same thread:
    Transaction.begin() // Hybris Counter now is 2
    lockRow() 
    // Row is locked for the whole transaction (the same opened in R1)
    // Everything is OK
    try {       
        Transaction.commit() // HybrisCounter -= 1
        // Transaction is not commited to DB because Hybris counter now is 1
        // Row is still locked
        // Next requests to the same row will wait lock forever
    } catch (Exception e) {
        Transaction.rollback();
    }