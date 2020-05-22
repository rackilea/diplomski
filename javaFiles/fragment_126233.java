@DataProvider(name="provideData")
    public  Iterator<Object[]> provideData() throws Exception
    {
        List<Object[]> data = new ArrayList<Object[]>();
        String[] retailerIDArray = retailerIDList.toArray(new String[retailerIDList.size()]);
        assertEquals(1295, retailerIDList.size(), "Expected 1295, found " + retailerIDList.size() + " docs");
        for(String retailerID : retailerIDArray ){

            data.add(new Object[]{retailerID});

        }

        return data.iterator(); 

    }

@Test(dataProvider = "provideData")
public void getRetailer(String retailerIDList) {

    for (String retailer_ID : retailerIDList) {
        //Code that uses the retailerID 
    }
}