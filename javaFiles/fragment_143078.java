@RunWith(MockitoJUnitRunner.class)
public class AsyncMockTest {

    @Mock
    private AsyncResponse response;

    @Captor
    private ArgumentCaptor<Response> captor;

    @Test
    public void testAsyncResponse() {
        final TestResource resource = new TestResource();
        resource.get(this.response);

        Mockito.verify(this.response).resume(this.captor.capture());
        final Response res = this.captor.getValue();

        assertThat(res.getEntity()).isEqualTo("Testing");
        assertThat(res.getStatus()).isEqualTo(200);
    }

    @Path("test")
    public static class TestResource {
        @GET
        @ManagedAsync
        public void get(@Suspended AsyncResponse response) {
            response.resume(Response.ok("Testing").build());
        }
    }
}