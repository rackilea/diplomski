@Test
public void testUpload() throws Exception {

            String endpoint = BASE_URL + "/upload/photo";

            FileInputStream fis = new FileInputStream("/home/me/Desktop/someDir/image.jpg");
            MockMultipartFile multipartFile = new MockMultipartFile("file", fis);

            HashMap<String, String> contentTypeParams = new HashMap<String, String>();
            contentTypeParams.put("boundary", "265001916915724");
            MediaType mediaType = new MediaType("multipart", "form-data", contentTypeParams);

            mockMvc.perform(
                    post(endpoint)
                    .content(multipartFile.getBytes())
                    .contentType(mediaType))
                    .andExpect(status().isOk());
}