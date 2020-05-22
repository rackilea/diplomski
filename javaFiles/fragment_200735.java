@Test
    public void readString() throws Exception {

        MockMultipartFile file = new MockMultipartFile("file", "original_filename.ext", null, "data".getBytes());

        webAppContextSetup(this.wac).build()
                .perform(fileUpload("/fileupload").file(file))
                .andExpect(model().attribute("message", "Attachment uploaded successfully"));
}