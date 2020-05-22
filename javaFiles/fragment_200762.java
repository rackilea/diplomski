plugins {
    application
    kotlin("jvm") version "1.3.61"
}

dependencies {
    api(project(":libraryA")) // we reference only library, we know nothing about the dependencies.
}