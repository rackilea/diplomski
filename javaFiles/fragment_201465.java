String[] command ={"/path/to/your/shellscript.sh", "shellscriptcommandlineparameter"};
ProcessBuilder pb = new ProcessBuilder(command);
pb.redirectOutput(new File("/tmp/output.txt"));
try {
    Process p = pb.start();
    p.waitFor();       

} catch (InterruptedException e) {
    e.printStackTrace();
}catch (Exception e1) {
    e1.printStackTrace();
}

}