for ( Field field : fields )
{
    if( field.getAnnotation( ChangesOnClone.class ) )
        continue;
    // else test it
}