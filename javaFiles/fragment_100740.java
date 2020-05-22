public class BlahMappingStrategy extends HeaderColumnNameMappingStrategy {
List<String> headerList;

public BlahMappingStrategy(List<String> headerList) {
    this.headerList = headerList;
}

@Override
public void captureHeader(CSVReader reader) throws IOException, CsvRequiredFieldEmptyException {
    if (this.type == null) {
        throw new IllegalStateException(ResourceBundle.getBundle("opencsv", this.errorLocale).getString("type.unset"));
    } else {
        String [] header = headerList.toArray(new String[headerList.size()]);
        this.headerIndex.initializeHeaderIndex(header);
    }
}