IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

IProject [] projects = root.getProjects();

List<String> names = new ArrayList<>();

for (IProject project : projects) {
   names.add(project.getName());
}