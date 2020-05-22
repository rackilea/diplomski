@Configuration
@EnableSolrRepositories
public class SolrContext {

  //..skipped solr server initialization to shorten

  @Bean
  public SolrTemplate solrTemplate() throws Exception {
    SolrTemplate solrTemplate = new SolrTemplate(solrServerFactory());
    solrTemplate.setSolrCore("collection1"); 
    solrTemplate.registerQueryParser(SimpleQuery.class, queryParser());
    return solrTemplate;
  }

  @Bean  
  public QueryParser queryParser() {
    DefaultQueryParser queryParser = new DefaultQueryParser();

    //register custom converter for Date
    queryParser.registerConverter(RoundDayConverter.INSTANCE);
    return queryParser;
  }

  private enum RoundDayConverter implements Converter<Date, String> {
    INSTANCE;

    private static final DateTimeFormatter FORMATTER = ISODateTimeFormat.dateTime().withZoneUTC();

    @Override
    public String convert(Date source) {
      if (source == null) {
        return "";
      }

      return ClientUtils.escapeQueryChars(FORMATTER.print(source.getTime())) + "/DAY";
    }
  }
}