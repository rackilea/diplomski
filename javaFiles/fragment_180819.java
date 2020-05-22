@Transactional
public void addEntityB(long entityAId, entityB) {
  EntityA entityA = loadEntityA(entityAId);
  addEntityBToEntityA(entityA, entityB);
  saveEntity(entityB);
}