/*
  OrderService
 */
public OrderService ()
{
     orderDAO = DAOFactory.getDAOFactory().getOrderDAO();
}

public setItemService (ItemService service)
{
     itemService = service;
}

/*
  ItemService
 */
public ItemService ()
{
     itemDAO = DAOFactory.getDAOFactory().getItemDAO();
}

public setOrderService (OrderService service)
{
     orderService = service;
}

/*
   Bring it together in some other class
 */
...
// instantiate singletons
orderService = new OrderService ();
itemService = new ItemService ();

// inject dependencies
orderService.setItemService (itemService);
itemService.setOrderService (orderService);