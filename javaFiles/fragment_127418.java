@ExtendWith(MockitoExtension.class)
class MyServiceTest {
    @Mock crsService;
    @Mock unitService;
    @InjectMocks MyService;

    @Test
    void testNoDataException() {
        CRS crs = mock(CRS.class);
        when(crsService.getCrsByCode(any())).thenReturn(crs);
        when(unitService.getUnits()).thenReturn(Collections.emptyList());

        assertThrows(DataNotFoundException.class,
                     () -> sut.getUnitSymbolForCRSCode(123));
    }
}