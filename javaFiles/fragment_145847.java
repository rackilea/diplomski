IContributedEnvironment environment = CCorePlugin.getDefault().getBuildEnvironmentManager().getContributedEnvironment();
ICProjectDescription projectDescription = CoreModel.getDefault().getProjectDescription(project, true);
ICConfigurationDescription config = projectDescription.getActiveConfiguration(); // or any other configuration...

// Add variable to project configuration
environment.addVariable("PKG_CONFIG_LIBDIR", dir, IEnvironmentVariable.ENVVAR_APPEND, null, config);

// Update project (description)
CoreModel.getDefault().setProjectDescription(project, projectDescription);