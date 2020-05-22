RuntimeMXBean mxBean = ManagementFactory.getRuntimeMXBean();

 for(String arg : mxBean.getInputArguments()){
    if(arg.startsWith("-Dmyarg.dir")){
        String [] filePath = arg.split("=");
        break;
    }
 }