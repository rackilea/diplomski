IPath path = Path.fromOSString(file);
IFile iFile = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(path);

ITextFileBufferManager iTextFileBufferManager = FileBuffers.getTextFileBufferManager();
ITextFileBuffer iTextFileBuffer = null;
IDocument iDoc = null;
try    {
    iTextFileBufferManager.connect(iFile.getFullPath(), LocationKind.IFILE, new NullProgressMonitor());
    iTextFileBuffer = iTextFileBufferManager.getTextFileBuffer(iFile.getFullPath(), LocationKind.IFILE);
    iDoc = iTextFileBuffer.getDocument();

    iTextFileBufferManager.disconnect(iFile.getFullPath(), LocationKind.IFILE, new NullProgressMonitor());
} catch (Exception e) {
    e.printStackTrace();
}

int start = iDoc.getLineOffset(iline - 1);
int end = iDoc.getLineLength(iline - 1);

//this next section was done to remove the leading white spaces                  
while(iDoc.getChar(start) == ' ' || iDoc.getChar(start) == '\t'){                                   
    start++;
    end--;
}

 final int charStart = start;
 final int charEnd = start + end;