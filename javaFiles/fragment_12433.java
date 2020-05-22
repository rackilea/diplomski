try ( final Reader reader = getPackageResourceReader(Q43231983.class, "success.json") ) {
    final Response response = gson.fromJson(reader, Response.class);
    System.out.println(response.progress.foo);
}
try ( final Reader reader = getPackageResourceReader(Q43231983.class, "failure.json") ) {
    final Response response = gson.fromJson(reader, Response.class);
    System.out.println(response.progress);
}