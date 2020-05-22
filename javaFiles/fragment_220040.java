public abstract class PojoClass {

    private Long idOrder;
    private Date date = new Date();
    private List<? extends IOrderLine> orderLines = new ArrayList<? extends IOrderLine>();
}