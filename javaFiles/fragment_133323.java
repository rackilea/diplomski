@Component
public class DBObjectToYearMonthConverter implements Converter<DBObject, YearMonth> {
    @Override
    public YearMonth convert(DBObject source) {
        return YearMonth.of(
            (int) source.get("year"),
            (int) source.get("month")
        );
    }
}