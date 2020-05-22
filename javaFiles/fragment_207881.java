public static void printCustomCommand(){
    String[] pids = {"pidof java"};
    String s;

try {
    Process pidProcess = Runtime.getRuntime().exec("/bin/bash -c pidof java");
    BufferedReader br = new BufferedReader(new InputStreamReader(pidProcess.getInputStream()));
    pids = br.readLine().split(" ");

    for (String pid : pids){
        String cmd = "/bin/bash -c lsof -p " + pid + " | grep jar >> /somepath/mydumpfile";
        Process p;
        p = Runtime.getRuntime().exec(cmd);
        BufferedReader reader = 
        new BufferedReader(new InputStreamReader(p.getInputStream()));

    String line = "";
    while((line = reader.readLine()) != null) {
        System.out.print(line + "\n");
    }

    p.waitFor();  
    }

    //pids = new String(bo).split(" ");
} catch (IOException e1) {
    // TODO Auto-generated catch block
    e1.printStackTrace();
} catch (InterruptedException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
}