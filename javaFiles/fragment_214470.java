@Mapper
public interface CompanyMapper {

    CompanyHeader entityToHeader(Company company, @Coontext Locale locale);

    default String getValueByLocale(Map<Locale, String> map, @Context Locale locale) {
        return map.get(locale);
    }
}