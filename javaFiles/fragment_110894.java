InputStream inStream = null;
        OutputStream outStream = null;

        File inputFile =new File("inputFile.txt");
        File outputFile =new File("outputFile.txt");

        inStream = new FileInputStream(inputFile);
        outStream = new FileOutputStream(outputFile);

        byte[] buffer = new byte[1024];


        int fileLength;
        while ((fileLength = inStream.read(buffer)) > 0){

              outStream.write(buffer, 0, fileLength );

              }

        inStream.close();
        outStream.close();