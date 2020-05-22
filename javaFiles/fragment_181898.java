public interface SomeTypeMongoRepository extends MongoRepository<SomeType, Long> {
    @Override
    @CacheEvict("someCache")
    <S extends SomeType> S insert(S entity);

    @Override
    @Cacheable("someCache")
    SomeType findOne(Long id);
}