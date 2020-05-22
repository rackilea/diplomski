public void testGetFizz() {
    // Directly extact
    Fizz fizz = r.path("fizz").accept("application/json").get(Fizz.class);
    System.out.println(fizz);

    // Extract from ClientResponse
    ClientResponse response = r.path("fizz").
                     accept("application/json").get(ClientResponse.class);
    Fizz fizz1 = response.getEntity(Fizz.class);
    System.out.println(fizz1);
}