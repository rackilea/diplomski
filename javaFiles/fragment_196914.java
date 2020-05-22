@Singleton
@Produces("text/csv")
@Provider
public class FederationCsvWriter implements MessageBodyWriter<TableData> {

  @Override
  public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
    return TableData.class.isAssignableFrom(type);
  }

  @Override
  public long getSize(TableData data, Class<?> type, Type genericType, Annotation annotations[], MediaType mediaType) {
    return -1;
  }

  @Override
  public void writeTo(TableData data, Class<?> type, Type genericType, Annotation[] annotations,
      MediaType mediaType, MultivaluedMap<String, Object> headers, OutputStream out) throws IOException {
    Writer osWriter = new OutputStreamWriter(out);
    CSVWriter writer = new CSVWriter(osWriter, ',', '"', "\r\n");
    if (data.getResultCount() > 0) {
      //Write the header
      writer.writeNext(data.getResult().get(0).keySet().toArray(new String[data.getResult().get(0).keySet().size()]));

      //Write the data
      for (ModelData row: data.getResult()) {
        writer.writeNext(row.values().toArray(new String[row.values().size()]));
      }
    }
    writer.flush();
  }

}