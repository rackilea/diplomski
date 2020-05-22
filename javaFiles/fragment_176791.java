Sigar sigar=new Sigar();
    ProcessFinder find=new ProcessFinder(sigar);
    long pid=find.findSingleProcess("Exe.Name.ct=explorer");
    ProcMem memory=new ProcMem();
    memory.gather(sigar, pid);
    System.out.println(Long.toString(memory.getSize()));