// define the dto interface
public interface LocaleDto {
  Integer getId();
  String getLocale();
}

// define a interface method in your repository
@Query("select a.id, b.locale from EntityA a join a.tabParam b where b.locale = ?1")
List<LocaleDto> findByTabParamLocale(Locale locale)

// or use
@Query("select id_A as id, locale from EntityB where locale = ?1")