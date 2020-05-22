public class ApiResponseSingleDto
{
    private ResponseDetail data;
}

public class ResponseDetail
{
    private Map<String, LocaleDetail> details;
}

public class LocaleDetail
{
    private String languageCode;
    private Boolean isPrimaryLocale;
    private String languageDisplayName;
}