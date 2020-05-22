configuration.addResource('APatched.hbm');
  configuration.buildMappings();
  PersistentClass toBePatched = configuration.getClassMapping(A.class.getName());
  String oldTableName = toBePatched.getTable().getName();
  toBePatched.getTable().setName(oldTableName + "_patched_not_existing");
  toBePatched.getTable().setAbstract(true);
  toBePatched.setAbstract(true);

  PersistentClass patched = configuration.getClassMapping(APatched.class.getName());
  patched.getTable().setName(oldTableName);