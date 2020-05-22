ProxyMyClass{   
    MyClass myclass;
    .
    .
    .
    sequence(){
     //Transaction Advisor code (Typically begin/check for transaction)
     myclass.sequence();
     //Transaction Advisor code(Typically rollback/commit)
    }
    .
    .
    .
    }