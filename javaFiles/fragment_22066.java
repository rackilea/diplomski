interface BookRepository extends Repository<Book, Integer> {

  @Query("select b from Book b " +
         "where b.from between ?1 and ?2 and b.to between ?1 and ?2")
  List<Book> findByDatesBetween(Date departure, Date arrival);
}