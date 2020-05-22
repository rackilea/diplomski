public static void main(String[] args) throws IOException {
    Process process = new ProcessBuilder("bash", "-c", "echo <password> | sudo -S ./yourExecutable").start();

    BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
    String string;
    while((string = errorReader.readLine()) != null){
        System.out.println(string);
    }

    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
    while((string = reader.readLine()) != null){
        System.out.println(string);
    }
}