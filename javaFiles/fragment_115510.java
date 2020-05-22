try {  
    Process p = Runtime.getRuntime().exec("python yourProgram.py thearg1 thearg2");  
    p.waitFor();
    InputStream stderr = proc.getOutputStream();
    InputStreamReader in = new InputStreamReader(stdout);
    BufferedReader reader = new BufferedReader(in);
    String line = null;
    while ((line = reader.readLine()) != null) {
        System.out.println("Python says: " + line);
    }
    int exitVal = proc.waitFor();
} catch (Exception e) {  
    e.printStackTrace();  
}