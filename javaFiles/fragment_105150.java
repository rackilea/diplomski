private List<FileItem> orderFileItems(List<FileItem> items){
    FileItem fileXML = null; // index 1
    FileItem filePDF = null; // index 0
    if(items.get(0).getName().endsWith("xml") && items.get(1).getName().endsWith("pdf")){
        fileXML = items.get(0);
        filePDF = items.get(1);
        items.set(0, filePDF);
        items.set(1, fileXML);
    }        
    return items;
}