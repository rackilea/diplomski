if (resource instanceof IFile) {

    IFile file = (IFile)resource;

    // The file name
    String name = file.getName();  

    IContainer folder = file.getParent();

    // The folder name
    String folderPath = folder.getFullPath().toString();
}