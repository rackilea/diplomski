Long mainEntityId = ...;
SomeEnum type = ...;   

//We only have the main entity's id so we need a reference
MainEntity mainEntityRef = entityManager.getReference( MainEntity .class, mainEntityId );

//Create a "prototype" for the lookup, only the id values are relevant
AnotherDependentEntity lookupEntity = new AnotherDependentEntity( mainEntityRef, type);

//Now perform the actual find, i.e. find the entity which matches the id of the lookup entity
AnotherDependentEntity actualEntity = entityManager.find( AnotherDependentEntity.class, lookupEntity );