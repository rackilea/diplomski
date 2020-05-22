public static String debugConnectionsToFile(File file) {
        if(!file.exists()){
            return "file does not exist!";
        }
        else if(!file.isFile()){
            return "File is not actually a file!";
        }
        else if(!file.canRead()){
            return "File cannot be read!";
        }

        else{
            try {
                FileReader reader = new FileReader(file);
                BufferedReader br = new BufferedReader(reader);
                try {
                    br.readLine();
                    br.close(); //It is true that this statement could cause an error, but it has never happened to me before.
                } catch (IOException e) {
                    return "File cannot be read by the reader!";
                }
            } catch (FileNotFoundException e) {
                return "File cannot be found or accessed by the reader";
            }
            return "It works fine!";
        }
    }