class Ticket implements Comparable<Ticket> {
    int number;
    boolean isValid;

    static belongsTo = [customer: Customer, queue: Queue]

    public Ticket(Customer customer, Queue queue, int number) {
        println "Create ticket, customer: ${customer}, queue:${queue}, number:${number}";
        this.customer = customer;
        this.queue = queue;
        this.number = number;
        this.isValid = true;
    }
}