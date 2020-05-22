public enum MerchantStatus implements MyEnum<MerchantStatus> {

    NEW("New"), ...


    @Override
    public MerchantStatus fromString(String type) {
     ...
    }

    @Override
    public String toString(MerchantStatus enumValue) {
     ...
    }
}