public class Game {
    private XMLGregorianCalendar startTime;

    @XmlElement
    @XmlSchemaType(name = "time")
    public XMLGregorianCalendar getStartTimeForSchema() {
      return startTime;
    }

    public void setStartTimeForSchema(XMLGregorianCalendar startTime) {
      this.startTime = startTime;
    }

    @XmlTransient
    public Date getStartTime() {
      return startTime.toGregorianCalendar().getTime();
    }

    @XmlTransient
    public void setStartTime(Date startTime) {
    GregorianCalendar gc = (GregorianCalendar) GregorianCalendar.getInstance();
      gc.setTime(startTime);
      DatatypeFactory dataTypeFactory = null;
      try {
        dataTypeFactory = DatatypeFactory.newInstance();
      } catch (DatatypeConfigurationException ex) {
        // log
      }
      this.startTime = dataTypeFactory.newXMLGregorianCalendar(gc);
    }
}