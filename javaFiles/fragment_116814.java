public static String getIP() throws IOException, InterruptedException {
    Process p = Runtime.getRuntime().exec("curl http://169.254.169.254/latest/meta-data/public-ipv4");
    int returnCode = p.waitFor();
    if ( returnCode == 0 ) {
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String ip = r.readLine();
        r.close();
        return ip;
    }
    else {
        //handle error
        return null;
    }
}