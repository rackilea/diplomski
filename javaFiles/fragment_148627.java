@SuppressWarnings({ "rawtypes", "unchecked" })
        public static void GetDirectory(String a_Path, List a_files, List a_folders) throws IOException {
            try {
                if (!new File(a_Path).exists())
                {
                   throw new FileNotFoundException("Given path '"+a_Path+"' is not available");
                }
                File l_Directory = new File(a_Path);
                File[] l_files = l_Directory.listFiles();

                for (int c = 0; c < l_files.length; c++) {
                    if (l_files[c].isDirectory()) {
                        a_folders.add(l_files[c].getName());
                    } else {
                            a_files.add(l_files[c].getName());
                    }
                }
            } 
            catch (FileNotFoundException ex){
               ex.printStackTrace();
            }
            catch (Exception ex){
                ex.printStackTrace();
            }            
        }