String filePath = request.getParameter(YOUR_FILE_PATH_PARAMETER");
        String filePath = filePath;
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename="
                + "YOUR_FILE_NAME");

        // Get it from file system
        FileInputStream in = new FileInputStream(new File(filePath));


        ServletOutputStream out = response.getOutputStream();

        byte[] outputByte = new byte[4096];
        // copy binary content to output stream
        while (in.read(outputByte, 0, 4096) != -1) {
            out.write(outputByte, 0, 4096);

                        in.close();
                        out.flush();
                        out.close();