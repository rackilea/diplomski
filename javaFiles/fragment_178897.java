subprojects {
    apply plugin: 'idea'

    idea {
        module {
            inheritOutputDirs = true
        }
    }
}