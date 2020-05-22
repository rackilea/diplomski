public Task<File> createFile(java.io.File yourfile, MediaHttpUploaderProgressListener uploadListener) {
        return Tasks.call(mExecutor, () -> {
            //Generates an input stream with your file content to be uploaded
            FileContent mediaContent = new FileContent("yourFileMimeType", yourfile);
            //Creates an empty Drive file           
            File metadata = new File() 
                    .setParents(parents) 
                    .setMimeType(yourFileMimeType)
                    .setName(yourFileName);

            //Builds up the upload request
            Drive.Files.Create uploadFile = mDriveService.files().create(metadata, mediaContent);
            //This will handle the resumable upload
            MediaHttpUploader uploader = uploadBackup.getMediaHttpUploader();
            //choose your chunk size and it will automatically divide parts
            uploader.setChunkSize(MediaHttpUploader.MINIMUM_CHUNK_SIZE); 
            //according to Google, this enables gzip in future (optional)
            uploader.setDisableGZipContent(false);  versions
            //important, this enables resumable upload
            uploader.setDirectUploadEnabled(false); 
            //listener to be updated
            uploader.setProgressListener(uploadListener);

            return uploadFile.execute();
        });
    }