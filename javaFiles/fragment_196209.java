TransformerFactory transformerFactory = TransformerFactory.newInstance();
Transformer transformer = transformerFactory.newTransformer();
DOMSource source = new DOMSource(doc);

FileOutputStream fos = null;
try {
    fos = new FileOutputStream(new File(activity
                .getExternalCacheDir().getAbsolutePath()
                + "/" + "Local storage" + ".xml"));
    Result fileResult = new StreamResult(fos);
    transformer.transform(source, fileResult);
} catch (FileNotFoundException e) {
    e.printStackTrace();
} finally {
    if (fos != null) {
        fos.close();
    }
}