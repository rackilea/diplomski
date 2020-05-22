server = new Server();

        int port = Integer.parseInt(portNumber);
        if (connector == null) {
            connector = createConnector(port);
        }
        server.addConnector(connector);

        for (Webapp webapp : webapps) {
            File sourceDirFile = new File(webapp.getWebappSourceDirectory());
            WebAppContext wac = new WebAppContext(sourceDirFile.getCanonicalPath(), webapp.getContextPath());
            WebAppClassLoader loader = new WebAppClassLoader(wac);
            if (webapp.getLibDirectory() != null) {
                Resource r = Resource.newResource(webapp.getLibDirectory());
                loader.addJars(r);
            }
            if (webapp.getClasspathEntries() != null) {
                for (String dir : webapp.getClasspathEntries()) {
                    loader.addClassPath(dir);
                }
            }
            wac.setClassLoader(loader);
            server.addHandler(wac);
        }
        server.start();