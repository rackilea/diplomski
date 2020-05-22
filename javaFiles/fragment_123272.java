@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JsonControllerIT {
    @LocalServerPort
    private int port;

    @Test
    public void jsonWithSerializationFeatureSet() {
        // given
        RestTemplate restTemplate = new RestTemplate();
        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        messageConverter.setObjectMapper(objectMapper);
        restTemplate.getMessageConverters().removeIf(m -> m.getClass().getName().equals(MappingJackson2HttpMessageConverter.class.getName()));
        restTemplate.getMessageConverters().add(messageConverter);

        // when
        Detail detail = restTemplate.getForEntity("http://localhost:" + port + "/json", Detail.class).getBody();

        // then
        assertThat(detail.getSingleItemList().get(0)).isEqualTo(3);
    }
}