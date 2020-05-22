DBObject query;
    //write appropriate query
    List<GridFSDBFile> fileList = gfs.find(query);
    for (GridFSDBFile f : fileList)
    {
        gfs.remove(f.getFilename());
        // if you have not set fileName and
        // your _id is of ObjectId type, then you can use 
        //gfs.remove((ObjectId) file.getId());
    }