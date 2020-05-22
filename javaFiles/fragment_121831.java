public static void main(String[] args) throws IOException {

        BasicFileAttributes thisFileBasicAttributes = null;
        Path pathOfThisFile = Paths.get("/myKey.store");
        System.out.println(pathOfThisFile);
        try{
        thisFileBasicAttributes = Files.readAttributes(pathOfThisFile, BasicFileAttributes.class);
        Object fileKeyBasic = thisFileBasicAttributes.fileKey();
        String output = "Basic: " + fileKeyBasic.toString();
        System.out.println(output);
        }
        catch(IOException exception)
        {
            System.err.println("JVM reported an exception, please take a look at" + exception);
        }

    }