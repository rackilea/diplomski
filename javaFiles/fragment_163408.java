final List<Future<MyResponse1>> futureMyResponse1Lst = new ArrayList<>();
for (final MyObject1 obj1: listOfObject1) {
    final Future<MyResponse1> resp1Future = myRestClient.getMyResponse1(obj1);

    Future<MyResponse1> resp1FutureComposite = Future.future();
    resp1Future.setHandler(event-> {
            final MyResponse1 resp1= event.result();
            handleResponse1(obj1, resp1);
            resp1FutureComposite.compelete(resp1);
    });
    futureMyResponse1Lst.add(resp1FutureComposite);
}