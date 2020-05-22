@Test
public void testResetValueWithFakeRequest() {
    Call call = controllers.routes.Application.resetValue(1);
    ImmutableMap<String, String> formData = ImmutableMap.of("username", "Jakob");
    RequestBuilder request = fakeRequest(call).bodyForm(formData);
    Result result = route(request);
    assertEquals(OK, result.status());
}