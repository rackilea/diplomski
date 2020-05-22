DefaultRepositorySystem repositorySystem =
            new DefaultRepositorySystem();
    repositorySystem.initService(locator);

    ModelResolver modelResolver =
            new ProjectModelResolver(session, requestTrace,
                    repositorySystem, remoteRepositoryManager, repos,
                    ProjectBuildingRequest.RepositoryMerging.POM_DOMINANT,
                    null);