bootJar {
    manifest {
        attributes(
            "GIT_REV": getHash()
        )
    }
}