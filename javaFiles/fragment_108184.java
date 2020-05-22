// myEntity (passed as parameter does not become managed)
// Only the one returned by the merge operation is a managed entity
session.merge(myEntity);

// "newValue" is not commited because myEntity is not managed
myEntity.setMyProperty("newValue");