@Test
public void uploadFileTest() throws Exception{
    //given
    InputStream uploadStream = UploadControllerTest.class.getClassLoader().getResourceAsStream("exceldocument.xlsx");
    MockMultipartFile file = new MockMultipartFile("file", uploadStream);
    assert uploadStream != null;

    //when
    this.mockMvc.perform(fileUpload("/DefectImport")
            .file(file))
    //then
            .andExpect(status().isOk());
}