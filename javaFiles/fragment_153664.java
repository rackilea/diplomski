project(":core") {
    apply plugin: "java"

    dependencies {
        ...
        compile files('libs/DungeonMapGenerator.jar') // ADDED THIS LINE
    }