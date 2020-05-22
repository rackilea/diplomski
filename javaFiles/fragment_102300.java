for (int i = 0; i < file.length; i++) {
               fstream = new FileInputStream(file[i]);
                       ostream = new      
                                   FileOutputStream(file[i].getName()); // This is never closed

                Path path = Paths.get(file[i].getPath());
                byte[] fileArray;
                fileArray = Files.readAllBytes(path);

                listModel.add(0, file[i].getName());
                selectedFilesList.setModel(listModel);
                              //ostream.write(fileArray, 0, fileArray.length);

            }

            fstream.close();  // Only the last input stream is closed