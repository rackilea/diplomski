writeStreamToFile(InputStream inputStream, File file) throws IOException {
    BufferedReader br = null;
    FileWriter writer = null;

        br = new BufferedReader(new InputStreamReader(inputStream));
        writer = new FileWriter(file);
        String line = null;
        while((line=br.readLine()) != null)
        {
            writer.append(line);
        }
    }