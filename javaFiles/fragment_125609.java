private File [] uploads;
private String [] uploadsFileName;
private String [] uploadsContentType;
private short isFileUpload [];

try {
    int fileIndex = 0;
    for (int i = 0; i < this.isFileUpload.length; i++) {
        if( this.isFileUpload[i] == 1 ) {
            System.out.println(" index    "+i+ " isFileUpload "+this.isFileUpload[i]);
            System.out.println("Index       "+i+ "     "+this.uploadsFileName[ fileIndex ]);
            String filePath = path;
            new File(filePath).mkdirs();
            FileUtils.copyFile(this.uploads[ fileIndex ], new File(filePath+"/"+i+"."+FilenameUtils.getExtension(this.uploadsFileName[ fileIndex ])));
            ++fileIndex;
        }
    }
} catch(Exception exception) {
    addActionError("Some files not uploaded.");
    exception.printStackTrace();
}