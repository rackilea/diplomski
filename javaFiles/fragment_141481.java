public Boolean testMultiFilesUpload(List<Part> parts, DataFetchingEnvironment env) {
        // get file parts from DataFetchingEnvironment, the parts parameter is not use
        List<Part> attachmentParts = env.getArgument("files");
        int i = 1;
        for (Part part : attachmentParts) {
            String uploadName = "copy" + i;
            try {
                part.write("your path:" + uploadName);
            } catch (IOException e) {
                e.printStackTrace();
            }
            i++;
        }
        return true;

    }
}