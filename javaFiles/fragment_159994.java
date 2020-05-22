InputStream sourceFile = zipFileUtil.getInputStream(zipEntry);
if(isValidAsPerXSD(sourceFile))
{
    sourceFile.close();
    sourceFile = zipFileUtil.getInputStream(zipEntry);
    //At this line Exception is Generated
    String xmlContent = IOUtils.toString(sourceFile);
}
sourceFile.close();