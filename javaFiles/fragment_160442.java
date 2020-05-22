input = getServletContext().getResourceAsStream(path);
output = response.getOutputStream();
byte[] buffer = new byte[1024];
for (int length = 0; (length = input.read(buffer)) > 0;) {
    output.write(buffer, 0, length);
}