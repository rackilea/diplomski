// Your upload handle would look like
public void doPost(HttpServletRequest req, HttpServletResponse res) {
    // Get the image representation
    ServletFileUpload upload = new ServletFileUpload();
    FileItemIterator iter = upload.getItemIterator(req);
    FileItemStream imageItem = iter.next();
    InputStream imgStream = imageItem.openStream();

    // construct our entity objects
    Blob imageBlob = new Blob(IOUtils.toByteArray(imgStream));
    MyImage myImage = new MyImage(imageItem.getName(), imageBlob);

    // persist image
    PersistenceManager pm = PMF.get().getPersistenceManager();
    pm.makePersistent(myImage);
    pm.close();

    // respond to query
    res.setContentType("text/plain");
    res.getOutputStream().write("OK!".getBytes());
}