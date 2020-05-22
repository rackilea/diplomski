@Test
public void someTest() throws Exception {
    //Some code...
    createAttachment();
    //Some more assertions...
}

@Attachment(name = "My cool attachment")
private byte[] createAttachment() {
    String content = "attachmentContent";
    return content.getBytes();
}