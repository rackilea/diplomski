public static void main(String[] args) throws IOException {
        ProcessBuilder builder = new ProcessBuilder("cmd");
        Process process = builder.start();

        OutputStream stdin = process.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(stdin));

        writer.write("cd ..\n");
        writer.write("dir\n");
        writer.flush();
        writer.close();

        BufferedReader commReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = "";

        while((line = commReader.readLine()) != null){

            System.out.println(line);
        }
    }