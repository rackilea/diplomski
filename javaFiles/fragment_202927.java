[WebMethod]
public int AddCustomer(Customer[] customers)
{

    for(int i=0;i<customers.Length;i++){
        //Access to customer fields for allrows via 
        int id = customers[i].Customer_ID;
        String name = customers[i].Customer_Name;
        String = customers[i].Customer_Family;
    }
    return customers.Length;

}