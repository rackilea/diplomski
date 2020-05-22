@Inject
MApplication app;

@Inject
EPartService partService;

// Find all the `MPart` objects in the current presentation

Collection<MPart> parts = partService.getParts();

// Filter the list to include just the parts that are current being displayed (rendered)

parts = parts.stream().filter(MPart::isToBeRendered).collect(Collectors.toList());