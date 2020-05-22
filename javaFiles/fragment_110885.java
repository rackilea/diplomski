class MyOrderMapped{

    private String orderNum;
    private String orderType;
    private String orderContent;
    private List<MyOrderMapped> nextOrderRefs;

    public MyOrderMapped(String orderNum, String orderType, String orderContent) {
        this.orderNum = orderNum;
        this.orderType = orderType;
        this.orderContent = orderContent;
        this.nextOrderRefs= new LinkedList<>();
    }

    // getters and setters

}