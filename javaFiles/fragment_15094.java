URL url = new URL("http://farm5.static.flickr.com/4132/5168797476_7a85deb2be_b.jpg");
            URLConnection con = url.openConnection();
            con.connect();
            int fileLength = con.getContentLength();
            InputStream is = con.getInputStream();
            byte[] bytes = new byte[fileLength];
            for(int i=0;i<fileLength;i++) {
                bytes[i] = (byte)is.read();
            }
            sourceBitmap = BitmapFactory.decodeByteArray(bytes, 0, fileLength);