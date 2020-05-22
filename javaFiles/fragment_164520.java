public void archieveFiles(File fileDirectory, String stringPassword) throws Exception {
        try{

            String[] filesDirectoryList = fileDirectory.list();

            ArrayList<File> listFileDirectory = new ArrayList<>(); //To list the files to archive
            for(int iListCount = 0; iListCount < filesDirectoryList.length; iListCount++){
                listFileDirectory.add(new File(fileDirectory+"\\"+filesDirectoryList[iListCount]));
            }

            ZipFile zipFile = new ZipFile("C:\\CreateZIP\\FileArchive.zip");
            //Initiate Zip Parameters which define various properties
            ZipParameters parameters = new ZipParameters();
            // Set compression method to deflate compression
            parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE); 
            parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL); 
            //Set the encryption flag to true
            parameters.setEncryptFiles(true);
            //Set the encryption method to AES Zip Encryption
            parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);
            //file encrypted with key strength of 192, then Zip4j can decrypt this file
            parameters.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);
            //Set password
            parameters.setPassword(stringPassword);
            // Zip the directory files
            zipFile.addFiles(listFileDirectory, parameters);
        }
        catch(ZipException ex){
            Logj.errorLog(ex);
        }
        catch(Exception ex){
            Logj.errorLog(ex);
        }
    }