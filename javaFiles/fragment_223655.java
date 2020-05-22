@Repository
public class AppointmentDAO {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private ApptReminderRepository apptReminderRepository;

    public List<Appointment> save(List<Appointment> appointments) {
        appointments.forEach(a -> this.save(a));
        return appointments;
    }

    public Appointment save(Appointment appointment) {
        final Appointment appt = appointmentRepository.save(appointment);
        List<ApptReminder> apptReminders = appointment.getApptReminders();
        apptReminders.forEach(a -> {
            a.getReminderKey().setApptId(appt.getApptId());
            a.getReminderTags().forEach(t -> t.setApptId(appt.getApptId()));
            a.getReminderMessages()
                    .forEach(m -> m.getReminderMessageKey().setApptId(appt.getApptId()));
            a.getMsgQueueReminder().setApptId(appt.getApptId());
        });
        apptReminderRepository.saveAll(apptReminders);
        return appointment;
    }
}