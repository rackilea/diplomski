public enum RedButton implements Button {
    INSTANCE;

    @Override
    public void getButton() {
        System.out.println("Red button");
    }
}