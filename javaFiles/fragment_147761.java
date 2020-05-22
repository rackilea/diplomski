Map<String, String> data = new HashMap<String, String>();
data.put("email", "guillaume@sample.com");
data.put("password", "secret");

Result result = callAction(controllers.routes.ref.Application.authenticate(),
  fakeRequest().withFormUrlEncodedBody(data));

assertThat(status(result)).isEqualTo(Status.SEE_OTHER);
assertThat(redirectLocation(result)).isEqualTo("/");
// All fine; we're logged in. Preserve the cookies:
String cookies = header(HeaderNames.SET_COOKIE, result);

// Fetch next page, passing the cookies
result = routeAndCall(fakeRequest(GET, redirectLocation(result))
  .withHeader(HeaderNames.COOKIE, cookies));

assertThat(status(result)).isEqualTo(Status.OK);
assertThat(contentAsString(result).contains("Guillaume Bort"));