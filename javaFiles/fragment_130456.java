@Mock private RepositoryItem   skuMockA;
    @Mock private RepositoryItem   skuMockB;

    List<RepositoryItem> skuList = new ArrayList<RepositoryItem>();

    @BeforeMethod(groups = { "unit" })
    public void setup() throws Exception {
        testObj = new YourDropletName();
        MockitoAnnotations.initMocks(this);

        skuList = new ArrayList<RepositoryItem>();
        skuList.add(skuMockA);
        skuList.add(skuMockB);


        Mockito.when(skuMockA.getPropertyValue("id")).thenReturn("skuA");
        Mockito.when(skuMockA.getPropertyValue("skuType")).thenReturn(ActiveSkuDroplet.EJSD);
        Mockito.when(skuMockA.getPropertyValue(ESTConstants.SKU_MISC1)).thenReturn("skuCodeA");
        Mockito.when(skuMockA.getPropertyValue("displayName")).thenReturn("skuADisplayName");

        Mockito.when(skuMockB.getPropertyValue("id")).thenReturn("skuB-PP");
        Mockito.when(skuMockB.getPropertyValue("skuType")).thenReturn(ActiveSkuDroplet.PJPROMIS);
        Mockito.when(skuMockB.getPropertyValue(ESTConstants.SKU_MISC1)).thenReturn("skuCodeB");
        Mockito.when(skuMockB.getPropertyValue("displayName")).thenReturn("skuBDisplayName");
    }