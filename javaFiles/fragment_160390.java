eclipse.classpath.file {
    whenMerged {  cp -> 
        // remove library dependencies
        def toBeRemoved = cp.entries.findAll { it instanceof Library 
              && ((Library) it).library.path.contains('someProject') }

        //configure the project dependencies:
        def toBeAdded = [ new ProjectDependency('/someProject', null)]

        cp.entries -= toBeRemoved
        cp.entries += toBeAdded
    }
}