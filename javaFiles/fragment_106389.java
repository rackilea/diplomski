public void modifySalary(Person person, float salary) {
    doTransaction(() -> person.setSalary(salary));
}

public void doTransaction(Runnable action) {
    em.getTransaction().begin();
    action.run();
    em.getTransaction().commit();
}