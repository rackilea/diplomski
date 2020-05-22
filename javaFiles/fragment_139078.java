task findJarsContaining {
    doLast {
        def jarTree = configurations.runtime.asFileTree.matching {
            include '*.jar'
        }
        jarTree.files.each { jarFile ->
            def matches = zipTree(jarFile).matching {
                include 'com/google/android/gms/auth/api/signin/internal/zzf.class'
            }.files
            if (matches) {
                println "Found $matches.size() matches in $jarFile.name"
            }
        }
    }
}