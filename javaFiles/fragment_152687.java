public class OrderHolder{
    private List<Order> orders;

    public List<Order> getOrders(){ return orders; }

} 

OrderHolder holder = new Gson().fromJson(response, OrderHolder.class);
modelData = holder.getOrders();