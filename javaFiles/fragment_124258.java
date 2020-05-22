public class UtcTimestampAdapter extends XmlAdapter<XMLGregorianCalendar, Date>
{
   @Override
   public XMLGregorianCalendar marshal(Date date) throws Exception
   {
      GregorianCalendar calendar = new GregorianCalendar();
      calendar.setTime(date);

      DatatypeFactory dataTypeFactory = DatatypeFactory.newInstance();
      XMLGregorianCalendar xmlCalendar = 
         dataTypeFactory.newXMLGregorianCalendar(calendar);

      //Reset time zone to UTC
      xmlCalendar.setTimezone(0);

      return xmlCalendar;
   }

   @Override
   public Date unmarshal(XMLGregorianCalendar calendar) throws Exception
   {
      return calendar.toGregorianCalendar().getTime();
   }
}