@Override
public Collection<Injectable<?>> start(GraphDatabaseService graphDatabaseService,
                                       Configuration config) {
    final List<Injectable<?>> injectables = new ArrayList<>();
    injectables.add(injectable(new CostlyServiceImpl, CostlyService.class)); // <<---
    return injectables;
}