private static void updateProjectDescription(IProject project) {
    String builderName = "org.eclipse.xtext.ui.shared.xtextBuilder";
    String xtextNature = "org.eclipse.xtext.ui.shared.xtextNature";
    IProjectDescription description = null;
    try {
        description = project.getDescription();
    } catch (CoreException exception) {
        exception.printStackTrace();
    }
    // add xtext builder:
    ICommand[] commands = description.getBuildSpec();
    ICommand command = description.newCommand();
    command.setBuilderName(builderName);
    if (Arrays.asList(commands).contains(command)) {
        logger.warn(".project already contains " + builderName);
    } else {
        ICommand[] newCommands = new ICommand[commands.length + 1];
        System.arraycopy(commands, 0, newCommands, 0, commands.length);
        newCommands[commands.length] = command;
        description.setBuildSpec(newCommands);
    }
    // Add xtext nature:
    String[] natures = description.getNatureIds();
    if (Arrays.asList(natures).contains(xtextNature)) {
        logger.warn(".project already contains " + xtextNature);
    } else {
        String[] newNatures = new String[natures.length + 1];
        System.arraycopy(natures, 0, newNatures, 0, natures.length);
        newNatures[natures.length] = xtextNature;
        description.setNatureIds(newNatures);
    }
    try {
        project.setDescription(description, new ProgressMonitorAdapter(logger));
    } catch (CoreException exception) {
        logger.fatal(exception);
    }
}