ByteArrayOutputStream out = new ByteArrayOutputStream();
Writer writer = new OutputStreamWriter(out, "UTF-8");
writer.append(queryArgs);
writer.flush();
//...
post.setEntity(new ByteArrayEntity(out.toByteArray()));