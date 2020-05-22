@Test
public void putTest() {
    ModelObject obj = new ModelObject("name", new ArrayList<>());
    String json = new Gson().toJson(obj);
    this.s3Dao.put(obj, "playlistId");

    verify(s3Client).putObject(S3Dao.BUCKET_NAME, "playlistId", json);
}