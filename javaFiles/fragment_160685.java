protected FileInfo createFileInfo(Object element) throws CoreException {
        FileInfo info = super.createFileInfo(element);
        if(info==null){
            info = createEmptyFileInfo();
        }
        IDocument document = info.fTextFileBuffer.getDocument();
        if (document != null) {

            /* register your partitioner and other things here 
                       same way as in your fisrt document provider */
        }
        return info;
    }