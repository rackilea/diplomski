sourceSets {
    main {
        java { exclude 'tests/** ' }
    }
    test {
        java { 
            srcDir 'src/main/java'
            include 'tests/**'
        }        
    }
}