public class BackingBean implements Serializable {
    @ManagedProperty(value="#{param.userId}")
    private Long userId;
    // implement getter/setter for userId

    public String deleteUser() {
        // at this point, the userId field should have been set via the param
    }
}