public class CountryCodeSerializerTest {

    private CountryCodeSerializer countryCodeSerializer;
    private JsonGenerator jsonGenerator;

    @Before
    public void setUp() throws Exception {
        countryCodeSerializer = new CountryCodeSerializer();
        jsonGenerator = mock(JsonGenerator.class);
    }

    @Test
    public void testNullCountryCodeThrowsIllegalArgumentException() throws Exception {
        try {
            countryCodeSerializer.serialize(null, jsonGenerator, null);
            fail("An IllegalArgumentException should have been thrown.");
        } catch (IllegalArgumentException e) {
            //ok
        }
    }

    @Test
    public void testCountryCodeConvertedToJsonString() throws Exception {
        countryCodeSerializer.serialize(CountryCode.parse("us"), jsonGenerator, null);
        verify(jsonGenerator).writeString("us");
    }
}