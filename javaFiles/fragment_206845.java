if(!file.exists()) 
{
    Object lock = null;
    synchronized (locks) {
       lock = locks.get(file.getName());
       if(lock == null) {
            lock = new Object();
            locks.put(file.getName(), lock);

       }
    }
    synchronized (lock) 
    {
        if(!file.exists()) 
        {
        logger.warn("Could not fild file in path: " + realPath);
        FileAttachment pictureAttachment = design.getThumbnailPicture();
        Hibernate.initialize(pictureAttachment.getAttachment());
        Data data = (Data) pictureAttachment.getAttachment();
        file = toolBox.convertBlobToFile(data.getBlob(), file);
        logger.warn("file created in path: " + realPath);
        }
    }
    synchronized(locks) { 
         map.remove(lock)); 
    }
}