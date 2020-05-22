bytesRead = input.read(buffer);
        if (bytesRead >= 0) {
            buffer = cipher.decryptFile(buffer, key);
            outStream.write(buffer, 0, bytesRead);
            counter += bytesRead;
        }