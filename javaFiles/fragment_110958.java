import datomic.*;

import java.util.List;
import java.util.Map;

public class DatomicUpdateExample {

    // converts an Entity to a Customer POJO
    static Customer customerFromEntity(Entity e){
        if(e == null || (e.get(":customer/id") == null)){
            throw new IllegalArgumentException("What you gave me is not a Customer entity.");
        }
        Customer cust = new Customer();
        cust.setId((Long) e.get(":customer/id"));
        cust.setName((String) e.get(":customer/name"));
        cust.setEmail((String) e.get(":customer/email"));
        cust.setPhone((String) e.get(":customer/phone"));
        cust.setVersion((Long) e.get(":model/version"));
        return cust;
    }

    // finds a Customer by
    static Customer findCustomer(Database db, Object lookupRef){
        return customerFromEntity(db.entity(lookupRef));
    }

    static List txUpdateCustomer(Database db, Customer newCustData){
        long custId = newCustData.getId();
        Object custLookupRef = Util.list(":customer/id", custId);
        Customer oldCust = findCustomer(db, custLookupRef); // find old customer by id, using a lookup ref on the :customer.id field.
        long lastKnownVersion = oldCust.getVersion();
        long newVersion = lastKnownVersion + 1;
        return Util.list( // transaction data is a list
                Util.map( // using a map is convenient for updates
                        ":db/id", Peer.tempid(":db.part/user"),
                        ":customer/id", newCustData.getId(), // because :customer/id is a db.unique/identity attribute, this will map will result in an update
                        ":customer/email", newCustData.getEmail(),
                        ":customer/name", newCustData.getName(),
                        ":customer/phone", newCustData.getPhone()
                ),
                // 'Compare And Swap': this clause will prevent the update from happening if other updates have occurred by the time the transaction is executed.
                Util.list(":db.fn/cas", custLookupRef, ":model/version", lastKnownVersion, newVersion)
        );
    }

    static void updateCustomer(Connection conn, Customer newCustData){
        try {
            Map txResult = conn.transact(txUpdateCustomer(conn.db(), newCustData)).get();
        } catch (InterruptedException e) {
            // TODO deal with it
            e.printStackTrace();
        } catch (Exception e) {
            // if the CAS failed, this is where you'll know
            e.printStackTrace();
        }
    }
}

class Customer {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private Long version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}