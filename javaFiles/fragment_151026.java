byte[] buffer = new byte[1024];
ByteArrayOutputStream out = new ByteArrayOutputStream();

int len;
while ((len = gzipper.read(buffer)) > 0) {
    out.write(buffer, 0, len);
}

gzipper.close();
out.close();
return out.toByteArray();