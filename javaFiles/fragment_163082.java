Response response = builder.get( Response.class );
if ( response.getStatusCode() != Response.Status.OK.getStatusCode() ) {
    // if they put the custom error stuff in the entity
    System.out.println( response.readEntity( String.class ) );
    return null;
}

return response.readEntity( MyEntity.class );