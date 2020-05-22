dos = new DataOutputStream(conn.getOutputStream());
    dos.writeBytes(twoHyphens + boundary + lineEnd);
    dos.writeBytes("Content-Disposition: form-data; name=\"file_name\";filename=\""
        + fileName + "\"" + lineEnd);
    dos.writeBytes(lineEnd);
    // Code for sending the image....
    dos.writeBytes(lineEnd);


    dos.writeBytes(twoHyphens + boundary + lineEnd);
    dos.writeBytes("Content-Disposition: form-data; name=\"file_name_audio\";filename=\""
        + fileNameAudio + "\"" + lineEnd);
    dos.writeBytes(lineEnd);
    // Code for sending the MP3
    dos.writeBytes(lineEnd);
    dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);