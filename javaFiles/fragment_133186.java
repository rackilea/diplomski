URL url;
        try {
            url = new URL("ftp://" + USER_NAME + ":" + PASSWORD + "@" + SERVER
                    + "/study/" + FILE_NAME + ";type=i");
            URLConnection con = url.openConnection();
            File tmpFile = new File("tmpFile.java");
            OutputStream out = new FileOutputStream(f);

            InputStream inputStream = con.getInputStream();

            byte buf[] = new byte[1024];
            int len;
            while ((len = inputStream.read(buf)) > 0)
                out.write(buf, 0, len);
            out.close();
            inputStream.close();

        } catch (IOException e) {
        }