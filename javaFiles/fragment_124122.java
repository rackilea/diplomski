public void getUpdate(Long currentVersionCode, HttpServletResponse response) throws Exception {
            //get latest number of apk from a db field
    Long dbVersionCode = apkUpdateRepository.findLastVersion();
    ServletOutputStream servletOutputStream = null;

    if (currentVersionCode == dbVersionCode){
        LOG.info("You have the last version");
        return;
    }

    if (currentVersionCode < dbVersionCode){
        FileInputStream inputStream = null;
        String filename = String.format(pathToApk, dbVersionCode);

        try{
        inputStream = new FileInputStream(filename);


        servletOutputStream = response.getOutputStream();

        byte[] buffer = new byte[1024];
        int bytesRead = 0;

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            servletOutputStream.write(buffer, 0, bytesRead);
        }

        servletOutputStream.flush();
        LOG.info("File streamed");

        LOG.info("Download "+filename);
        }finally{
            if (inputStream!=null){
                inputStream.close();
            }
            if (servletOutputStream != null){
                servletOutputStream.close();
            }
        }
    }
}