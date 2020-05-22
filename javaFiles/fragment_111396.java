@Command
public void deleteRegistration(Registration reg) {
    reg.getCourse().getRegistrations().remove(reg);
    reg.getParticipant.getRegistrations().remove(reg);
    registrationMgr.delete(reg);
}