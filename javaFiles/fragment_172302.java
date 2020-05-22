[DEBUG] javax.annotation:javax.annotation-api:jar:1.3.2:
[DEBUG]    org.codehaus.plexus:plexus-utils:jar:1.1:runtime
[DEBUG] Created new class realm extension>
        javax.annotation:javax.annotation-api:1.3.2
[DEBUG] Importing foreign packages into class realm extension>
        javax.annotation:javax.annotation-api:1.3.2
[DEBUG]   Imported:  < maven.api
[DEBUG] Populating class realm extension>
        javax.annotation:javax.annotation-api:1.3.2
[DEBUG]   Included: javax.annotation:javax.annotation-api:jar:1.3.2
[DEBUG]   Included: org.codehaus.plexus:plexus-utils:jar:1.1
[DEBUG] Dependency collection stats: {...}
[DEBUG] javax.annotation:jsr250-api:jar:1.0:
[DEBUG]    org.codehaus.plexus:plexus-utils:jar:1.1:runtime
[DEBUG] Created new class realm extension>
        javax.annotation:jsr250-api:1.0
[DEBUG] Importing foreign packages into class realm extension>
        javax.annotation:jsr250-api:1.0
[DEBUG]   Imported:  < maven.api
[DEBUG] Populating class realm extension>
        javax.annotation:jsr250-api:1.0

....

[DEBUG] Extension realms for project some-group:some-artifact:some-packing:some-version : 
    [ClassRealm[extension>javax.annotation:javax.annotation-api:1.3.2, 
                parent: sun.misc.Launcher$AppClassLoader@5c647e05], 
     ClassRealm[extension>javax.annotation:jsr250-api:1.0, 
                parent: sun.misc.Launcher$AppClassLoader@5c647e05]]
[DEBUG] Created new class realm project>some-group:some-artifact:some-version
[DEBUG] Populating class realm project>some-group:some-artifact:some-version
[DEBUG]   Included: javax.annotation:javax.annotation-api:jar:1.3.2
[DEBUG] Looking up lifecycle mappings for packaging war from 
    ClassRealm[project>some-group:some-artifact:some-version,
              parent: ClassRealm[maven.api, parent: null]]