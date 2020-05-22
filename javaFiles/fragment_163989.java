public static void main(String[] args) throws MalformedURLException,
            IOException {
        URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());

        String url = "hdfs://" + NAMENODE_IP + FILE_PATH;

        InputStream is = new URL(url).openStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line = br.readLine();
        while(line != null) {
            System.out.println(line);
            line = br.readLine();
        }
    }