apply plugin: 'java'

archivesBaseName = 'foo-client'
sourceCompatibility = JavaVersion.VERSION_1_7
targetCompatibility = JavaVersion.VERSION_1_7

task copyToLib(type: Copy){
    into 'bar\\lib'
    from configurations.runtime
    from configurations.default.allArtifacts.getFiles()
}

dependencies{
    compile 'foo:bar-agent-dist:2.0.0-SNAPSHOT', 
            'foo:bar-common:2.0.0-SNAPSHOT', 
            'foo:bar-communication-api:2.0.0-SNAPSHOT'
}


repositories{ 
    flatDir{
        dirs '/lib'
    }
}