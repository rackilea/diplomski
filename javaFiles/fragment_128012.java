byte[] buffer = new byte[5 * 1024];
        int numRead = -1;
        while( (numRead = bufferedInputStream.read(buffer))!= -1)
        {
            byteArrayOutputStream.write(buffer, 0, numRead);
        }
        byteArrayOutputStream.flush();
        byteArrayOutputStream.close();
        byte[] result = byteArrayOutputStream.toByteArray();