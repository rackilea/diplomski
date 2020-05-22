ClassLoader loader = getClass().getClassLoader();
    URL url = loader.getResource("META-INF/application.xml");
    BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
    while (true) {
        String line = reader.readLine();
        System.out.println(line);
        if (line == null) {
            break;
        }
    }