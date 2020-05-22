Response response = builder.get( Response.class );
if ( response.getStatusCode() != Response.Status.OK.getStatusCode() ) {
    System.out.println( response.getStatusType() );
    return null;
}

return response.readEntity( MyEntity.class );