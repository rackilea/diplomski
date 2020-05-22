byte[] buffer = new byte[4096];
            int nBytesRead = 0;
            while (nBytesRead != -1) {
                nBytesRead = decodedStream.read(buffer, 0, buffer.length);
                // Write read bytes to out stream
                byteOut.write(buffer, 0, nBytesRead);
                //                    ^^^^^^^^^^^^^
            }