public static void main(String[] args) throws Exception {
    XMLGregorianCalendar xc = DatatypeFactory.newInstance().newXMLGregorianCalendar(2017, 10, 13, 0, 0, 0, 0, 0);
    System.out.println(xc);
    GregorianCalendar gc = xc.toGregorianCalendar();
    System.out.println(gc);
    ZonedDateTime zdt = gc.toZonedDateTime();
    System.out.println(zdt);
    LocalDateTime ldt = zdt.withZoneSameInstant(ZoneId.of("America/Los_Angeles")).toLocalDateTime();
    System.out.println(ldt);
}