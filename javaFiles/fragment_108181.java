Path directory = ...;
Files.newDirectoryStream(directory)
     .forEach(p -> {
         try {
            String fileName = p.getFileName().toString();
            String filePath = p.toAbsolutePath().toString();
            long fileLen =  Files.size(p);
            long filelastModified = Files.getLastModifiedTime(p).toMillis();
        } catch (IOException e) {
            // FIXME to handle
        }

     });