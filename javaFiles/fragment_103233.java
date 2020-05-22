String path = Thread.currentThread()
                    .getContextClassLoader()
                    .getResource("/")
                    .toURI()
                    .resolve("../mylog4j.properties")
                    .getPath();
Properties props = new Properties();
props.load(new FileInputStream(path));
PropertyConfigurator.configure(props);