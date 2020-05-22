catch (Exception e)
{
    logger.error("Unexpected error on saving/updating the DB.", e);

    this.em.getTransaction().rollback();

    logger.info("RollBack done.");
    throw MyFailedDbOperationException("my db operation failed");
}