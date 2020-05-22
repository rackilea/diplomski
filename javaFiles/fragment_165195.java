ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ZipOutputStream zip = new ZipOutputStream(baos);

    .... populate ZipOutputStream

    String filename = "out.zip";
    // the response variable is just a standard HttpServletResponse
    response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");
    response.setContentType("application/zip");

    try{            
        response.getOutputStream().write(baos.toByteArray());
        response.flushBuffer();
    }
    catch (IOException e){
        e.printStackTrace();        
    }
    finally{
        baos.close();
    }