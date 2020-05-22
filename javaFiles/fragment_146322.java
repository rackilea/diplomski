/* MongoRepository provides entity-based default Spring Data methods */
/* BookDataRepositoryCustom provides field-level update methods */
public interface BookDataRepository extends MongoRepository<BookData, String>, BookDataRepositoryCustom {

    BookData findById(String id);

}

/* Interface for the custom methods */
public interface BookDataRepositoryCustom {

    int saveCurrentPage(String id, Integer currentPage);
}

/* Custom implementation using MongoTemplate. */
@SuppressWarnings("unused")
public class BookDataRepositoryImpl implements BookDataRepositoryCustom {
    @Inject
    MongoTemplate mongoTemplate;

    @Override
    public int saveCurrentPage(String id, Integer currentPage) {
        Query query = new Query(Criteria.where("_id").is(id));
        Update update = new Update();
        update.set("currentPage", currentPage);

        WriteResult result = mongoTemplate.updateFirst(query, update, BookData.class);

        return result == null ? 0 : result.getN();
    }
}

// Old code: get entity from DB, update, save. 3 steps with plenty of room for interferences.
//        BookData bookData = bookDataRepository.findById(bookDataId);
//        bookData.setCurrentPage(currentPage);
//        bookDataRepository.save(bookData);
// New code: update single field. 1 step, 0 problems.
        bookDataRepository.saveCurrentPage(bookDataId, currentPage);