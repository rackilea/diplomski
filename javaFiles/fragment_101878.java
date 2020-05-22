@XmlRootElement
public class Customers extends Plural<Customer> {

    @XmlElement(name = "customer")
    public Collection<Customer> getCustomers() {
        return getSingulars();
    }
}

@XmlRootElement
public class Items extends Plural<Item> {

    @XmlElement(name = "item")
    public Collection<Item> getItems() {
        return getSingulars();
    }
}

@XmlRootElement
public class Invoices extends Plural<Invoice> {

    @XmlElement(name = "invoice")
    public Collection<Invoice> getInvoices() {
        return getSingulars();
    }
}

@XmlRootElement
public class BrettRyans extends Plural<BrettRyan> {

    @XmlElement(name = "brettRyan")
    public Collection<BrettRyan> getBrettRyans() {
        return getSingulars();
    }
}