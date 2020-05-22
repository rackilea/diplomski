String id = request.getParameter("id");

// ...

InputStream input = resultSet.getBinaryStream("imageColumnName");
OutputStream output = response.getOutputStream();
response.setContentType("image/gif");
// Now write input to output the usual way.