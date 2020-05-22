@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

       // define your custom query
        @Query("SELECT t FROM Todo t WHERE t.title = :title")
        public List<Todo> findByTitleIs(@Param("title") String title);


        // write here all the Todo queries
    }