try {
    is = urlc.getInputStream();
} catch(FileNotFoundException fnfe){
    is = ((HttpURLConnection) urlc).getErrorStream();
    LOG.log(Level.WARNING, "Exception streaming image: \n" + IOUtils.toString(is));
    throw fnfe;
}