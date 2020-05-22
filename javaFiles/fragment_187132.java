@Test
public void testGetNonExistantVideosData() throws Exception {

    long nonExistantId = getInvalidVideoId();

    try{
        Response r = videoSvc.getData(nonExistantId);
        assertEquals(404, r.getStatus());
    }catch(RetrofitError e){
        assertEquals(404, e.getResponse().getStatus());
    }
}