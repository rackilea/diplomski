for(Customer c:customers) {

    MyCallable myCallable = new MyCallable(restTemplate, c);
    //System.out.println(c);
    Future<String> future= executor.submit(myCallable);
    myFutureList.add(future);

}