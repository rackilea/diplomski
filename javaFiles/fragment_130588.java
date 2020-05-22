private Double getCpuFromProcess( String process ) {
    //PID USER PR NI VIRT RES SHR S %CPU %MEM TIME+ COMMAND
    Double result = 0.0;
    String[] items = process.replace("  "," ").replace("  "," ").split(" ");
    result = Double.valueOf( items[8].replace(",", ".") );
    return result;
}