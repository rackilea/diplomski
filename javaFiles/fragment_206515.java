// if your config.ini file is in the com package.
URL url = getClass().getClassLoader().getResource("com/config.ini");
System.out.println("URL=" + url);

InputStream is = getClass().getClassLoader().getResourceAsStream("com/config.ini");
try {
    if (is != null) {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }
    else {
        System.out.println("resource not found.");
    }
}
catch (IOException e) {
    e.printStackTrace();
}