public static void main(String[] args) throws Exception {
    String[] processArgs = new String[]{"ping","google.com"};
    Process process = new ProcessBuilder(processArgs).start();

    BufferedReader in = new BufferedReader(new InputStreamReader(
            //I'am using Win7 with PL encoding in console -> "CP852"
            process.getInputStream(), "CP852"));

    String line;
    while ((line = in.readLine()) != null)
        System.out.println(line);

    in.close();
    System.out.println("process ended");
}