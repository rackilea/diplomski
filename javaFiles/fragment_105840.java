public class ParseLocalDate extends CellProcessorAdaptor {

    public ParseLocalDate() {
        super();
    }

    public ParseLocalDate(CellProcessor next) {
        super(next);
    }

    @Override
    public Object execute(Object value, CsvContext context) {
        validateInputNotNull(value, context);

        DateTimeFormatter[] dateFormats = {
            DateTimeFormat.forPattern("yyyy-MM-dd"),
            DateTimeFormat.forPattern("MM/dd/yyyy") };

        LocalDate date = null;
        for (DateTimeFormatter dtf : dateFormats) {
            try {
                date = LocalDate.parse(value.toString(), dtf);
                break;
            } catch (Exception e) {
                // was not able to be parsed with this format, do nothing
            }
        }

        if (date == null)       
            throw new SuperCsvCellProcessorException("Date could not be parsed", context, this);

        return date;
    }
}