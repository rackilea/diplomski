userID = 4; // Example user ID, which we got from somewhere earlier in the code

templateID = 20; // Example template ID, which we got from somewhere earlier in the code

// Create template entity (loading by primary key)
template = EntityLoadByPK( 'Template', templateID );

// To set the user in the Template entity, we must pass a User entity
user = EntityLoadByPK( 'User', userID );

// Only then can we successfully update the template's foreign key property
template.setUser( user );
EntitySave( template );

// Line below is not usually needed, but it forces DB interaction so it's 
// useful in the context of this example
ORMFlush();