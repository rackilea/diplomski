try {

        File outputFile = new File("YOUR DESIRED FILE PATH");


        FileOutputStream fos = new FileOutputStream(outputFile);
        int c;

        while ((c = fileInputStream.read()) != -1) {
           fos.write(c);
        }

        fileInputStream.close();
        fos.close();
    } catch (FileNotFoundException e) {
        System.err.println("FileStreamsTest: " + e);
    } catch (IOException e) {
        System.err.println("FileStreamsTest: " + e);
    }