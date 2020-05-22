public void create(Project project) {
        entityManager.persist(project);
        entityManager.getTransaction().commit();
        project = entityManager.find(Project.class, project.getProjectId());
        entityManager.refresh(project);
        System.out.println("Id    -- " + project.getProjectId());
            System.out.println("no -- " + project.getProjectNo());
    }