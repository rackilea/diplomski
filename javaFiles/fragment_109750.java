@InitBinder
public void binder(WebDataBinder binder) {
    binder.registerCustomEditor(XMLGregorianCalendar.class, new PropertyEditorSupport() {
       public void setAsText(String value) {
           setValue(createXMLGregorianCalendar(value));
        }

        public String getAsText() {
            return new SimpleDateFormat("dd/MM/yyyy").format(((XMLGregorianCalendar)getValue()).toGregorianCalendar().getTime());
        }  
    });
}

private XMLGregorianCalendar createXMLGregorianCalendar(String date) {
    LocalDateTime result = DateTimeFormat.forPattern("dd/MM/yyyy").parseDateTime(date).toLocalDateTime();
    return xmlDF().newXMLGregorianCalendar(result.toDateTime().toGregorianCalendar());
}


private static DatatypeFactory xmlDF() {
    try {
        return DatatypeFactory.newInstance();
    } catch (DatatypeConfigurationException ex) {
        throw new RuntimeException(ex);
    }
}