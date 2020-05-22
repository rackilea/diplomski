Properties templateProps = new Properties();

templateProps.setProperty( "file.resource.loader.modificationCheckInterval", 60); // This is in seconds
templateProps.setProperty( "file.resource.loader.cache", "true" );

Velocity.init( templateProps );