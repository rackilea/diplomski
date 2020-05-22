for (InputStream in : files.keySet()) {
    String ext = files.get(in);

    if(ext.equalsIgnoreCase("pdf"))
    {
        //load pdf here
    }
    else if(ext.equalsIgnoreCase("png") || ext.equalsIgnoreCase("jpg"))
    {
        //load image here
    }
}