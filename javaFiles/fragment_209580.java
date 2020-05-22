public class TestConcreteClasses {
    public static void main(String[] args) {
        Payment payment = new Payment();
        payment.setAmount(52.6);
        createData(payment);
        CreditCard creditCard = new CreditCard();
        creditCard.setAmount(10);
        creditCard.setCcNumber("2536985474561236");
        creditCard.setExpireDate(new Date());
        createData(creditCard);

    }

    private static void createData(Payment instance) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(instance);
        session.getTransaction().commit();
    }
}