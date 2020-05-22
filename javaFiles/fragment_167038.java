public class PersonAPITest {
        private static APIResponse _response = null;

        @Test
        public void testSignIn() {
            // Setup signal to prevent from test ending before all async tasks finish.
            final CountDownLatch signal = new CountDownLatch(1);

            // call API method for signing in
            PersonAPI.signIn("asdf@asdf.co", "Free Milk Lane", new IAPICallback() {public void done(APIResponse response) {

               // check response for errors
               PersonAPITest._response = response;

               // mark async operation is completed
               signal.countDown();
            }});

          // wait until all async operations completed
          signal.await(5, TimeUnit.SECONDS);

          Assert.assertTrue(PersonAPITest._response.getMessage(), PersonAPITest._response.isSuccessful());
        }
    }