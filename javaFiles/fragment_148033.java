private void filterOrders()
{
    List<OrderLine> list = new ArrayList<>();

    for(OrderLine ol : orderListing)
    {
        boolean addOrderLine = false; // need to ensure items outside date range not added      
        if(ol.getOrderDate().before(currentEndDate) && 
              ol.getOrderDate().after(currentStartDate))
        {
             addOrderLine = true;
             for(CheckBoxFilter cbf : currentFilterList)
             {
                 //ol.getFilterList simply returns a list of the filters.
                 //cbf.getInternalName returns the name of the filter the CheckBox is associated with.
                 if(!ol.getFilterList().toString().contains(cbf.getInternalName()))
                {
                    addOrderLine = false;
                }
            }
        }
        if(addOrderLine)
        {
            list.add(ol);
        }
    }

    filteredOrderLineList = list;
    for(OrderLine ooll : filteredOrderLineList)
    {
        System.out.println(ooll.toString());
    }
}