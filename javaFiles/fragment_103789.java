while (offset < uc.getContentLength()) {
            bytesRead += in.read(data, offset, data.length - offset);
            if (bytesRead == -1) {
                break;
            }
            offset += bytesRead;
            System.out.println("Finished downloading: " + bytesRead + " Bytes");
        }