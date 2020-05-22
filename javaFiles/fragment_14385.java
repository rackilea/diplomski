@Autowired
private List<Processor> processorsList; //Autowiring all implementation of Processor

// Return an autowired instance of a particular implementation
private Processor getProcessor(Class<? extends Processor> cls) {
    for (Processor p: processorsList)
        if (cls.isInstance(p))  return p;
    return null;
}