private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyyMMdd");

@PostConstruct
private void loadIcs() {
    eventModel = new DefaultScheduleModel();
    CalendarBuilder builder = new CalendarBuilder();

    try {
        net.fortuna.ical4j.model.Calendar calendar = builder.build(this.getClass().getResourceAsStream("canada.ics"));

        for (Iterator i = calendar.getComponents().iterator(); i.hasNext();) {
            Component component = (Component) i.next();
            //new event
            Date start = SDF.parse(component.getProperty("DTSTART").getValue());
            Date end = SDF.parse(component.getProperty("DTEND").getValue());
            String summary = component.getProperty("SUMMARY").getValue();

            eventModel.addEvent(new DefaultScheduleEvent(summary,
            start, end));

            System.out.println("added "+start+end+summary);

        }
    } catch (IOException e) {
        e.printStackTrace();
    } catch (ParserException e) {
        e.printStackTrace();
    } catch (ParseException e) {
        e.printStackTrace();
    }

}