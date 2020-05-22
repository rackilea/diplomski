Agenda lAgenda = new Agenda();
...
for (Event e : myEvents) {
    lAgenda.appointments().add(
        new Agenda.AppointmentImpl()
        .withStartTime(e.getStartTime())
        .withEndTime(e.getEndTime()));
        ...
}