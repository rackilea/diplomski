public ServiceIntervalByProduct getServiceInterval(
        Contract pContract, BillCycle pBillCycle)  {
    ServiceIntervalByProduct  returnMap = new ServiceIntervalByProduct();

    List<product> productList = getAllproducts(pContract);

    for (product product : productList)
    {
        Date billingDate = getBillingDate(product);

        createReturnMap(
                product, returnMap,
                billingDate, pBillCycle);
    }

    return returnMap;
}

// First level Wrapper class
public class ServiceIntervalsByProduct{

  private Map<Product, ServiceIntervalsByDate>> mapByProduct;   

  public void add(Product product, Date date, ServiceInterval serviceInterval) {
   // add in inner map
  }

 public ServiceInterval getServiceInterval (Product product, Date date){
   // get from inner map
    return mapByProduct.get(product).getServiceInterval (date);    
 }
}


// Second level Wrapper class
public class ServiceIntervalsByDate{
  private  SortedMap<Date, ServiceInterval>> mapByDate;

  public void add(Date date, ServiceInterval serviceInterval){
   // add in inner map    
  }

  public ServiceInterval getServiceInterval (Date date){
   // get from inner map
    return mapByDate.get(date);
   }

}