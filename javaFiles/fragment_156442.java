@Converter
public class LocalDateToDateConverter implements AttributeConverter<LocalDate, Date>
{
   @Override
   public Date convertToDatabaseColumn( LocalDate attribute )
   {
      return attribute == null ? null : new Date( attribute.toDate().getTime() );
   }

   @Override
   public LocalDate convertToEntityAttribute( Date dbData )
   {
      return dbData == null ? null : LocalDate.fromDateFields( dbData );
   }

}