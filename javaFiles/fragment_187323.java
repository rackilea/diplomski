public void persistSubtasks(int idEstoria, Collection<Estoria> subtasks) {
    Estoria rootEstoria = entityManager.createNamedQuery("Estoria.findById", Estoria.class)
                .setParameter("id", idEstoria)
                .getSingleResult();
    for(Estoria subtask:subtasks){
        subtask.setSubtask(rootEstoria);
    }
    rootEstoria.setSubtasks(subtasks);
}