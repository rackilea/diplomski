PhotoProcessingBean extends FileProcessingBean {...}
VideoProcessingBean extends FileProcesingBean {...}

class FileProcessingFactory {
    public static FileService createFileService(FileDescriptor descriptor) {
        switch(descriptor.getFileType()) {
            case 'Photo': return new PhotoProcessingBean();
            case 'Video': return new VideoProcessingBean();
            default: // do some error handling
        }
    }
}