// check the version unsaved-value, if appropriate
final Object version = getVersion( entity );
if ( isVersioned() ) {
    // let this take precedence if defined, since it works for
    // assigned identifiers
    Boolean result = entityMetamodel.getVersionProperty()
            .getUnsavedValue().isUnsaved( version );
    if ( result != null ) {
        return result;
    }
}