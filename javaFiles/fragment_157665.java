public String projectCollaborators(@PathVariable Long projectId, Model model) {
    (... your code ...)

    model.addAttribute("project", project);

    // Add the next line to add the "rolesCollaborators" instance
    model.addAttribute("rolesCollaborators", new RolesCollaborators());

    return "project_collaborators";
}