ByteArrayOutputStream baos = null;
MimeMultipart mp = new MimeMultipart(new ByteArrayDataSource(inputStream, contentType));
int count = mp.getCount();
baos = new ByteArrayOutputStream();

for (int i = 0; i < count; i++) {
    BodyPart bodyPart = mp.getBodyPart(i);
    Object content = bodyPart.getContent();
    String content = new String(read(bodyPart));

    String partContentType =  bodyPart.getContentType();
}

bodyPart.writeTo(MIMEbaos);
String attachment = MIMEbaos.toString();

    private static byte[] read(BodyPart bodyPart) throws MessagingException, IOException
    {
        InputStream inputStream = bodyPart.getInputStream();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        int data = 0;
        byte[] buffer = new byte[1024];

        while ((data = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, data);
        }

        return outputStream.toByteArray();
    }