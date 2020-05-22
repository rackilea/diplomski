@Command
public void deleteRegistration(Registration reg) {
    // remove reference from course, else delete does nothing
    Course c = getRegistration().getCourse();
    c.getRegistrations().remove(getRegistration());
    courseMgr.saveOrUpdate(c);

    // delete registration from the database
    registrationMgr.delete(reg);
}