@Test
public void test() {
   running(fakeApplication(), new Runnable() {
       public void run() {
           String username = "Aerus";
           Result res = route(fakeRequest("GET", "/")
                            .withSession("username", username)
                            .withSession("key","value"));
           assert(contentAsString(res).contains(username));
       }
   });
}