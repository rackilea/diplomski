try {
    saveFile = new FileOutputStream(cacheDir + "PL"+url.getQuery())
} catch (FileNotFoundException e1) {
    // TODO Auto-generated catch block
    e1.printStackTrace();
}