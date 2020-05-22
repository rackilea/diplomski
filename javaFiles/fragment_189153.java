EntityType<MyEntity> entity = emf.getMetamodel().entity(MyEntity.class);

EntityTypeImpl entityTypeImpl = (EntityTypeImpl) entity;        
ClassDescriptor descriptor =  entityTypeImpl.getDescriptor();

String schema = descriptor.getDefaultTable().getTableQualifier();