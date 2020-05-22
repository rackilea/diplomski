...
    while((bytes_read = from_server.read(reply)) != -1) {
                to_client.write(reply, 0, bytes_read);
                to_client.flush();
                baos.write(reply, 0, bytes_read);
              }
    baos.flush();
...