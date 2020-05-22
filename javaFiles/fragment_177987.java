IWorkspace workspace = ResourcesPlugin.getWorkspace();
            IWorkspaceRoot root = workspace.getRoot();

            String projectName = projectNames[indices[i]];

            IProject newProjectHandle = root.getProject(projectName.replace("Examples_", ""));

            newProjectHandle.create(new NullProgressMonitor());
            IProjectDescription description = workspace
                    .newProjectDescription(newProjectHandle.getName());

            newProjectHandle = CCorePlugin.getDefault().createCProject(description,
                    newProjectHandle, new NullProgressMonitor(),
                    ManagedBuilderCorePlugin.MANAGED_MAKE_PROJECT_ID);
            IndexerPreferences.set(newProjectHandle,
                    IndexerPreferences.KEY_INCLUDE_HEURISTICS, "true");