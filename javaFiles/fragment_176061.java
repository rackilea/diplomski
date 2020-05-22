File folder = new File("FarmCalc");
                        // if file doesn't exist, then create it
                        if (!folder.exists()){
                            folder.mkdir();
                        }
                        final File file = new File("/Users/"+user+"/FarmCalc/"+beta.getText()+".txt");
                        // if file doesn't exist, then create it
                        if (!file.exists()) {
                            file.createNewFile();
                        }