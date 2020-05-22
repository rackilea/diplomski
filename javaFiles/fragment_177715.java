projects.values()
        .stream()
        .flatMap(p->p.getProcesses().stream())
        .forEach(proc1 ->  projects.values()
                                   .stream()
                                   .flatMap(p->p.getProcesses().stream())
                                   .forEach(proc2 -> {/*do something with proc1 and proc2*/});