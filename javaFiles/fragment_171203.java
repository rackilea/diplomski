Runtime rt = Runtime.getRuntime();
try {
    String cmd = "javac";
    // OR String cmd = "cmd /c javac";
    // OR String cmd = "java -cp myjar com.my.sample";
    Process p = rt.exec(cmd);
    BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream())); 

    String line;
    while ((line = br.readLine()) != null) {
        System.out.println(line);
    }

    p.waitFor();
} catch(Exception e){
    e.printStackTrace();
}