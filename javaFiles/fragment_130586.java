private void getRunningProcesses() throws Exception {
    Process process = Runtime.getRuntime().exec("top -b -n1 -c");
    InputStream is = process.getInputStream();
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader br = new BufferedReader(isr);
    String line;
    while ( (line = br.readLine()) != null) {
        if( line.contains("java") ) processes.add( line );  
    }   
}