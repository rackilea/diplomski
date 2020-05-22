File file = new File(filePath);
        boolean fileDelete = file.delete();

            if (fileDelete) 
            { 
                    mLogger.debug("successfully deleted");
            } else {
                mLogger.error("cant delete a file");
            }