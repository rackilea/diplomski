public void extractFilesForFirmwareZip(String stringArchievedFile, String stringExtractingFilePath, String stringFileEncrypt) throws Exception{
        try{
            // Initiate ZipFile object with the path/name of the zip file.
            ZipFile zipFile = new ZipFile(stringArchievedFile);
            //Initiate Zip Parameters which define various properties
            //UnzipParameters parameters = new UnzipParameters();
            if(zipFile.isEncrypted())
                zipFile.setPassword(stringFileEncrypt);
            //Extracts all files to the path specified
            zipFile.extractAll(stringExtractingFilePath);
        }
        catch(ZipException ex){
            isValidArchiveFile = false;
            Logj.doLog(ex.getMessage(), ex);
        }
        catch(Exception ex){
            throw ex;
        }
    }