String filename = "русское слово.txt";

ContentDisposition contentDisposition = ContentDisposition.builder("attachment")
    .filename(filename, StandardCharsets.UTF_8)
    .build();
System.out.println(contentDisposition.toString());