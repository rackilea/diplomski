pom {

    project {
        name POM_NAME
        packaging POM_PACKAGING
        description POM_DESCRIPTION
        url POM_URL

        scm {
            url POM_SCM_URL
            connection POM_SCM_CONNECTION
            developerConnection POM_SCM_DEV_CONNECTION
        }

        licenses {
            license {
                name POM_LICENCE_NAME
                url POM_LICENCE_URL
                distribution POM_LICENCE_DIST
            }
        }

        developers {
            developer {
                id POM_DEVELOPER_ID
                name POM_DEVELOPER_NAME
            }
        }
    }

    whenConfigured {
        p - >
            p.dependencies = p.dependencies.findAll {
                dep - > (dep.artifactId.notIn(["play-services"]))
            }
    }
}

//https://stackoverflow.com/a/26810828/2614364
Object.metaClass.notIn = { Object collection ->
    !(delegate in collection)
}