public void create(Project project) {
    ProjectType type = project.getType(); // maybe check if null
    if (!entityManager.contains(type)) {  // type is transient
        type = entityManager.merge(type); // or load the type
        project.setType(type); // update the reference
    }

    int progressive = type.getProgressive();
    type.setProgressive(progressive + 1); // mark as dirty, update on flush

    // set "code" before persisting "project" ...
    project.setCode(type.getPrefix() + progressive);
    entityManager.persist(project);

    // ... now no additional UPDATE is required after the
    // INSERT on "project".
}