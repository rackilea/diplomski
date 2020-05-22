FileReader filereader = new FileReader("data.txt");
        BufferedReader ifile = new BufferedReader(filereader); 
        String N;
        ArrayList<String> file_contents= new ArrayList<String>();
        //List will now contain the whole txt

        try {
            while((N = input.readLine()) != null) {
                file_contents.add(N);
            }
            ifile.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }