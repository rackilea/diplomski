Process p;
    String output = null;
    try {
        String command = "grep searchString filename.txt";
        System.out.println("Running command: " + command);

        p = Runtime.getRuntime().exec(command);
        p.waitFor();

        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));

            while ((output = br.readLine()) != null) {
                System.out.println(output);
                // Process your output here
            }

        System.out.println("exit: " + p.exitValue());
        p.destroy();
    } catch (Exception e) {
        e.printStackTrace();

}