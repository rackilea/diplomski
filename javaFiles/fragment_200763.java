plugins {
    kotlin("jvm") version "1.3.61"
}

dependencies {
    api(project(":libraryB")) // again, we know nothing about the dependencies
}