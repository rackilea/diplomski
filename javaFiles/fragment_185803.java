File directory = new File(fileChooser.getSelectedFile().getAbsolutePath());
  getFiles(directory);//calls method to get all the files in the directory
  ...
  void getFiles(File directory) {
            for( File f : directory.listFiles() ){
                if(!f.isDirectory()) {//is a file lets read it
                    FileInputStream fstream = new FileInputStream(f);
                    DataInputStream in = new DataInputStream(fstream);
                    BufferedReader br = new BufferedReader(new InputStreamReader(in));
                    bw.write(br.readLine() + "\n");
               }else {//wil make it a recursive search
                   getFiles(f);
               }
          }
    }