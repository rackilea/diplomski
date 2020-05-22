@RunWith(PowerMockRunner.class)
@PrepareForTest({UUIDStasher.class})
public class TestUUIDStasher {

    private final String expectedUUID = "19dcd640-0da7-4b1a-9048-1575ee9c5e39";
    Path spoofPath = Paths.get("C:\\TSG");

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        PowerMockito.mockStatic(Paths.class);
        PowerMockito.mockStatic(Files.class);
        when(Paths.get(any(String.class))).thenReturn(spoofPath);
        when(Files.readAllBytes(any(Path.class))).thenReturn(expectedUUID.getBytes());
    }

    @Test
    public void testGetUUID() throws Exception {
        UUIDStasher stasher = new UUIDStasher();
        String retrieved = stasher.getUuid();
        Assert.assertEquals(expectedUUID, retrieved);
    }
}