// check the id unsaved-value
Boolean result = entityMetamodel.getIdentifierProperty()
        .getUnsavedValue().isUnsaved( id );
if ( result != null ) {
    return result;
}