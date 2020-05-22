OutputStream outputStream = null;
    File file1 = new File("/tmp/output.txt");
    try
    {
        outputStream = new FileOutputStream(file1);

        int read = 0;
        byte[] bytes = new byte[1024];
        while ((read = in1.read(bytes)) != -1) {
            outputStream.write(bytes, 0, read);
        }
         } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally
        {
            if(outputStream != null)
            { 
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    ExecuteShell.executeJavaCommand(file1.getAbsolutePath());

    logger.info("action=output.txt converted from dos to unix");

    InputStream in = null;
    try {
        in = new FileInputStream(file1);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }