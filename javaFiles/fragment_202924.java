public class Customer implements KvmSerializable {
public int Customer_ID;
public String Customer_Name;
public String Customer_Family;

public Customer() {
}

public Customer(int customer_id,
                String customer_name, 
                String customer_family) {

    Customer_ID = customer_id;
    Customer_Name = customer_name;
    Customer_Family = customer_family;
}

public Object getProperty(int arg0) {
    // TODO Auto-generated method stub
    switch (arg0) {
    case 0:
        return Customer_ID;
    case 1:
        return Customer_Name;
    case 2:
        return Customer_Family;


    }
    return null;
}

public int getPropertyCount() {
    // TODO Auto-generated method stub
    return 25;
}

public void getPropertyInfo(int index, Hashtable arg1, PropertyInfo info) {
    // TODO Auto-generated method stub
    switch (index) {
    case 0:
        info.type = PropertyInfo.INTEGER_CLASS;
        info.name = "Customer_ID";
        break;
    case 1:
        info.type = PropertyInfo.STRING_CLASS;
        info.name = "Customer_Name";
        break;
    case 2:
        info.type = PropertyInfo.STRING_CLASS;
        info.name = "Customer_Family";
        break;
    default:
        break;

    }
}

public void setProperty(int index, Object value) {
    // TODO Auto-generated method stub
    switch (index) {
    case 0:
        Customer_ID = Integer.parseInt(value.toString());
        break;
    case 1:
        Customer_Name = value.toString();
        break;
    case 2:
        Customer_Family = value.toString();
        break;
    default:
        break;
    }

}

}