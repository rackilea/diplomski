@Override
void apply(Project project) {
    Map<String, String> sharedModel = new HashMap<>()
    sharedModel.put("path", ":shared:model")
    project.dependencies.add("compile", project.dependencies.project(sharedModel))
}