File body = new File();
body.setTitle("My document");
body.setDescription("A test document");
body.setMimeType("text/plain");

final String textContent = "Hi! my first google doc!";
ByteArrayInputStream bis = new ByteArrayInputStream(textContent.getBytes("UTF-8"));
InputStreamContent content = new InputStreamContent();
content.inputStream = bis;
Drive.files.insert(body, content);