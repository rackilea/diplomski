resourceSuppliers.put("A", new Supplier<Resource>() {
    @Override
    public Resource get() {
        return Utils.getResourceA();
    }
});