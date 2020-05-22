final List<Future<MyResponse1>> futureMyResponse1Lst = new ArrayList<>();
for (final MyObject1 obj1: listOfObject1) {
    final Future<MyResponse1> resp1Future = myRestClient.getMyResponse1(obj1);

    Future<MyResponse1> resp1FutureComposite = resp1Future.compose(resp1 -> {
            handleResponse1(obj1, resp1);
            return Future.succeededFuture(resp1);
    });
    futureMyResponse1Lst.add(resp1FutureComposite);
}