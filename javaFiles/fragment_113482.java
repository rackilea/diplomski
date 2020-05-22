@Test
public void bugbla() throws Exception {
    XMLSlideShow ppt = XSLFTestDataSamples.openSampleDocument("51187.pptx");
    for(XSLFPictureData data : ppt.getPictureData()){
        byte[] bytes = data.getData();
        String fileName = data.getFileName();       
        PictureType pictureFormat = data.getType();                         
        System.out.println("picture : " + fileName); 
        System.out.println("pictureSize : " + data.getImageDimensionInPixels()); 
    }
}