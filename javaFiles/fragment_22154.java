try {
        inputStream = new FileInputStream(basePath + "/" + fileName);
        byte[] buffer = new byte[4096];
        int bytesRead = 0;
        do {
            bytesRead = inputStream.read(buffer, 0, buffer.length);
            httpServletResponse.getOutputStream().write(buffer, 0, bytesRead);
        } while (bytesRead == buffer.length);

        /* some code for set attributes to httpServletResponse */
    } finally {
        if (inputStream != null)
            inputStream.close();
    }