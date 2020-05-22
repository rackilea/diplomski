while ((bufferLength = fileInputStream.read(buffer)) > 0) {
        //add the data in the buffer to the file in the file output stream (the file on the sd card
        Log.i("bytes available ", "" + fileInputStream.available());
        Log.i("buffer length", "" + bufferLength);

        outputStream.write(buffer, 0, bufferLength);
        //add up the size so we know how much is downloaded

    }