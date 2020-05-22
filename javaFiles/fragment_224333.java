Path path = new Path(uri[0].getPath().toString());
    if (fileSystem.exists(path)) {
        FSDataInputStream dataInputStream = fileSystem.open(path);

        byte[] data = new byte[1024];
        while (dataInputStream.read(data) > 0) {
            //do your stuff here
        }

        dataInputStream.close();
    }