public static void main(String[] args) {

        String db = "pack";
        String col = "col";
        String Host = "localhost";
        String Port = "27017";
        String fileName = "D:/files/sample.csv";

    String command = "C:\\Program Files\\MongoDB\\Server\\3.4\\bin\\mongoexport.exe --host " + Host + " --port " + Port + " --db " + db + " --collection " + col + " --type=csv --fields _id,email,createdAt, --out " + fileName + "";

    try {
        System.out.println(command);

        StringTokenizer st = new StringTokenizer(command);
        String[] cmdarray = new String[st.countTokens()];
        for (int i = 0; st.hasMoreTokens(); i++)
            cmdarray[i] = st.nextToken();

        ProcessBuilder processBuilder = new ProcessBuilder(cmdarray);
        processBuilder.redirectErrorStream(true);

        Process process = processBuilder.start();
        BufferedReader processOutput = new BufferedReader(new InputStreamReader(process.getInputStream()));

        String s = "";
        while ((s = processOutput.readLine()) != null) {
            System.out.println(s);
        }


    } catch (Exception e) {
        e.printStackTrace();
    }