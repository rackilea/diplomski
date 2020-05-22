@Override
    default void deleteById(UUID id)
    {
        Assert.notNull(id, "The given id must not be null!");

        Optional<T> entity = this.findById(id);
        entity.ifPresent(this::delete);
    }

    @Override
    default void delete(T entity)
    {
        Assert.notNull(entity, "The entity must not be null!");

        entity.setActive(Boolean.FALSE);
        this.save(entity);
    }

    @Override
    default void deleteAll(Iterable<? extends T> entities)
    {
        Assert.notNull(entities, "The given Iterable of entities must not be null!");

        for (T entity : entities)
        {
            this.delete(entity);
        }
    }

    @Override
    default void deleteAll()
    {
        for (T element : this.findAll())
        {
            this.delete(element);
        }
    }