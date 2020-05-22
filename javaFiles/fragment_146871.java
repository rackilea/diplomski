`  
              //on startup
               installDir("");
                for (int i = 0; i < toInstall.size(); i++) {
                    File f = toInstall.get(i);
                    String deepPath = f.getPath().replace(f.getPath().substring(0, f.getPath().lastIndexOf("resources") + "resources".length() + 1), "");
                    System.out.println(deepPath);
                    System.out.println("INSTALLING: " + deepPath);
                    installDir(deepPath);
                    System.out.println("INDEX: " + i);
                }

public void installDir(String path) {
            System.out.println(path);
            final URL url = getClass().getResource("/resources/" + path);
            if (url != null) {
                try {
                    final File apps = new File(url.toURI());
                    for (File app : apps.listFiles()) {
                        System.out.println(app);
                            System.out.println("copying..." + app.getPath() + " to " + pfFolder.getPath());
                            String deepPath = app.getPath().replace(app.getPath().substring(0, app.getPath().lastIndexOf("resources") + "resources".length() + 1), "");
                            System.out.println(deepPath);

                        try {

                                File f = new File(resources.getPath() + "/" + deepPath);
                                if (getExtention(app) != null) {
                                FileOutputStream resourceOS = new FileOutputStream(f);
                                byte[] byteArray = new byte[1024];
                                int i;
                                InputStream classIS = getClass().getClassLoader().getResourceAsStream("resources/" + deepPath);
                        //While the input stream has bytes
                                while ((i = classIS.read(byteArray)) > 0) 
                                {
                        //Write the bytes to the output stream
                                    resourceOS.write(byteArray, 0, i);
                                }
                        //Close streams to prevent errors
                                classIS.close();
                                resourceOS.close();
                                } else {
                                    System.out.println("new dir: " + f.getPath() + " (" + toInstall.size() + ")");
                                    f.mkdir();
                                    toInstall.add(f);
                                    System.out.println(toInstall.size());
                                }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (URISyntaxException ex) {
                    // never happens
                }
            }

        }`