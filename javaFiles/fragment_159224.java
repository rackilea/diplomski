@RunWith(PowerMockRunner.class)
    @PrepareForTest({ Unirest.class})
    public class TestApp{

      @Before
      public void setup() {
        PowerMockito.mockStatic(Unirest.class);
      }

      @Test
      public void shouldTestgetActivites() throws UnirestException {
        when(Unirest.get(Client.DEFAULT_BASE_URL)).thenReturn(getRequest);
        when(getRequest.asJson()).thenReturn(httpResponse);
        when(httpResponse.getStatus()).thenReturn(Integer.valueOf(200));

        assertThat(something).isEqualTo(true);
      }

    }