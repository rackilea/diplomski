// Recursive resource processor
// Here can be images inside in PDXObjectForm objects
protected static void processResources(PDResources resources, PDDocument doc, String filename) throws IllegalArgumentException, SecurityException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, JBIG2Exception, ColorSpaceException, ICCProfileException
{
    if(resources == null) return;
    Map<String, PDXObject> xObjects = resources.getXObjects();
    if (xObjects == null) return;

    // iterate by images
    Iterator<String> imageIter = xObjects.keySet().iterator();
    while (imageIter.hasNext()) 
    {
        String key =  imageIter.next();

        PDXObject o = xObjects.get(key);

        if(o instanceof PDXObjectImage)
            xObjects.put(key, processImage((PDXObjectImage) o /*, some additional parms... */));

        if(o instanceof PDXObjectForm)
            processResources(((PDXObjectForm) o).getResources(), doc, filename);
    }

    resources.setXObjects(xObjects);
}