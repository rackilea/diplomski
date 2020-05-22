include "springint"
project(":springint").projectDir = file("/users/me/git/spring-integration")

rootProject.name = 'sprinttest'

project(":springint").projectDir.eachDir { dir ->
    if (dir.name.startsWith('spring-integration-')) {
        include "springint:${dir.name}"
    }
}