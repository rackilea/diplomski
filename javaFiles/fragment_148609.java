whenConfigured {
    p - >
        p.dependencies = p.dependencies.findAll {
            dep - > (dep.artifactId.notIn(["junit", "play-services"]))
        }
}