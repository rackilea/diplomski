String path = "d:\\test.txt";
                    File f = new File(path);

                    try {
                        if (f.createNewFile())
                            System.out.println("file created.");
                        else
                            System.out.println("file not created");
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }