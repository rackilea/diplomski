Thread download = new Thread(){
    public void run(){
        URL url= new URL("http://overpass-api.de/api/interpreter?data=area%5Bname%3D%22Hoogstade%22%5D%3B%0A%28%0A++node%28area%29%3B%0A++%3C%3B%0A%29+%3B%0Aout+meta+qt%3B");
        String localFilename="mylocalfile"; //needs to be replaced with local file path
        downloadFromUrl(url, localFilename);
    }
};
download.start();//start the thread