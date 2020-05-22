try {
    OutputStream output = connection.getOutputStream();
    output.write(query.getBytes(charset));
}catch (Exception e) {
    e.printStackTrace();
}