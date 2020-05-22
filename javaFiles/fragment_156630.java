ModuleLayer.boot()
    .modules()
    .stream() 
    .map(Module::getDescriptor) 
    .filter(md -> !md.provides().isEmpty()) 
    .forEach(md -> System.out.format("%s -> %s%n", md.name(), md.provides()));