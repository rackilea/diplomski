String versionRange = "[0,)";

    Artifact artifact =
        new DefaultArtifact( "org.testng:testng:jar:" + versionRange );
    VersionRangeRequest rangeRequest = new VersionRangeRequest();
    rangeRequest.setArtifact( artifact );
    rangeRequest.setRepositories( remoteRepos );

    VersionRangeResult rangeResult = repository.resolveVersionRange( repositorySystemSession, rangeRequest );
    List<Version> versions = rangeResult.getVersions();