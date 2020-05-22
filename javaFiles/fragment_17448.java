@Nonnull
public List<ProjectLevel<?>> findUUIDByNameorNumber(@Nonnull final String nameOrId,
                                                    @Nonnull final String businessAccountId) {
    checkNotNull(nameOrId, "The nameOrId must not be null");

    return getEntityManager()
            .createNamedQuery("ProjectLevel.findUUIDByNameOrId")
            .setParameter("name", matchesFromBeginning(nameOrId))
            .setParameter("businessAccountId", businessAccountId)
            .getResultList();
}