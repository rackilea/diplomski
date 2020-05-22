out = new PrintWriter(client.getOutputStream());

    private void returnFileContent(File f) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(f));
        String linea;

        while ((line = br.readLine())!=null){
            out.println(line); out.flush();
        }
        br.close();
    }