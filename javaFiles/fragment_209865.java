public interface InformationDao extends CrudRepository<Information,Long> {
    List<Information> findAll();
}

public interface ElementDao  extends CrudRepository<Element, Long> {
    List<Element> findAll();
    Element findByValue(String value);
    Element findById(Long id);
}