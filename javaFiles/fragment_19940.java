private void iterateAll()
{
    int offset = 0;

    List<Model> models;
    while ((models = Model.getAllModelsIterable(offset, 100)).size() > 0)
    {
        entityManager.getTransaction().begin();
        for (Model model : models)
        {
            log.info("do something with model: " + model.getId());
        }

        entityManager.flush();
        entityManager.clear();
        em.getTransaction().commit();
        offset += models.size();
    }
}