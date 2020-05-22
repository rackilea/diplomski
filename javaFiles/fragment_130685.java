@Test
    public void function() throws Exception{
        RuleEngineUtil r = new RuleEngineUtil();
        URL u = PowerMockito.mock(URL.class);
        String url = "http://www.sdsgle.com";
        PowerMockito.whenNew(URL.class).withArguments(url).thenReturn(u);
        HttpURLConnection huc = PowerMockito.mock(HttpURLConnection.class);
        PowerMockito.when(u.openConnection()).thenReturn(huc);
        PowerMockito.when(huc.getResponseCode()).thenReturn(200);
        assertTrue(r.isUrlAccessible(url));

    }