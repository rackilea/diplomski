if ( entityMetamodel.getIdentifierProperty().isEmbedded() ) {
        if ( entity != id ) {
            //copy the id (snipped for simplicity)
        }
    }
    ... //check and handling for a setter, not relevant here
    else if ( identifierMapperType != null ) {
        mappedIdentifierValueMarshaller.setIdentifier( entity, id, getEntityMode(), session );
    }