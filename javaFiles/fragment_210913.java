GenericTest(Super<Exception> s){
        List<? extends Exception> list = getList();

    }

    <F extends Exception> List<F> getList(){...}