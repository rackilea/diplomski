public class ZonedDateTimeSerializer extends JsonSerializer<ZonedDateTime>
{

  @Override
  public void serialize( ZonedDateTime value, JsonGenerator gen, SerializerProvider serializers ) throws IOException
  {
    gen.writeStartObject();
    gen.writeFieldName( "timestamp" );
    gen.writeString( Long.toString( value.toInstant().toEpochMilli() ) );
    gen.writeFieldName( "offset" );
    gen.writeString( value.getOffset().toString() );
    gen.writeFieldName( "zone" );
    gen.writeString( value.getZone().toString() );
    gen.writeFieldName( "ts" );
    gen.writeString( StringUtils.convertZonedDateTimeToISO8601String( value ) );
    gen.writeEndObject();
  }

}