try {
        File jarFile = new File("D:\\Workspace\\Test\\Test.jar");
        URLClassLoader loader = new URLClassLoader(new URL[]{jarFile.toURI().toURL()});

        Class.forName("com.bla.bla.HelloWorld", true, loader);
        System.out.println("Success");
        loader.close();
    } catch (MalformedURLException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }