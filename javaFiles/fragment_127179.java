final List<Dependency> dependencies = project.getDependencies();

    for (Dependency d : dependencies) {

        final Artifact artifact =
            artifactFactory.createArtifactWithClassifier(d.getGroupId(),
                d.getArtifactId(), d.getVersion(), d.getType(),
                d.getClassifier());

        try {
            resolver.resolve(artifact, remoteRepositories,
                    localRepository );
        } catch (ArtifactResolutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ArtifactNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        File artifactFile = artifact.getFile();
        System.out.println(artifactFile.getAbsolutePath());
    }