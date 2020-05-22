for (int i = 0; i < file.length; i++) {
              try {
                 fstream = new FileInputStream(file[i]);
                 ostream = new      
                      FileOutputStream(file[i].getName());

                  Path path = Paths.get(file[i].getPath());
                  byte[] fileArray;
                  fileArray = Files.readAllBytes(path);

                  listModel.add(0, file[i].getName());
                  selectedFilesList.setModel(listModel);
                  //ostream.write(fileArray, 0, fileArray.length);
               } finally {
                 fstream.close();
                 ostream.close();
               }
            }