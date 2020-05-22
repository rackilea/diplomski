WebClient client = WebClient.create("http://books");
client.type("multipart/form-data");
ContentDisposition cd = new ContentDisposition("attachment;filename=image.jpg");
Attachment att = new Attachment("root", imageInputStream, cd);
client.post(new MultipartBody(att));

// or just post the attachment if it's a single part request only
client.post(att);

// or just use a file
client.post(getClass().getResource("image.png").getFile());