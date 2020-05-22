public class PositionBean {  
    private Long id;
    private Date receive;

    public void setReceive (Date receive) {
        this.receive = receive;
    }

    @JsonSetter
    public void setReceive (Long receive) {
        this.receive = new Date (receive);
    }

    public Long getReceive () {
        return receive.getTime ();
    }
}